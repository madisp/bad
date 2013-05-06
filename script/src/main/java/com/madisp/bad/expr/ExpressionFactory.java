package com.madisp.bad.expr;

import com.madisp.bad.parse.ExprBaseVisitor;
import com.madisp.bad.parse.ExprLexer;
import com.madisp.bad.parse.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 5:41 PM
 */
public class ExpressionFactory extends ExprBaseVisitor<Expression> {

	public Expression buildExpression(String expr) {
		ExprLexer lexer = new ExprLexer(new ANTLRInputStream(expr));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		return visitLine(parser.line());
	}

	@Override
	public Expression visitLine(ExprParser.LineContext ctx) {
		return visitProg(ctx.prog());
	}

	@Override
	public Expression visitProg(ExprParser.ProgContext ctx) {
		List<Expression> statements = new ArrayList<Expression>();
		statements.add(visitExpr(ctx.expr()));

		ExprParser.ProgContext prog = ctx.prog();
		while (prog != null) {
			statements.add(visitExpr(prog.expr()));
			prog = prog.prog();
		}
		return new StatementList(statements.toArray(new Expression[statements.size()]));
	}

	@Override
	public Expression visitExpr(ExprParser.ExprContext ctx) {
		if (ctx.NOT() != null) {
			return new NotExpression(visitExpr(ctx.center));
		} else if (ctx.AND() != null) {
			return new AndExpression(visitExpr(ctx.left), visitExpr(ctx.right));
		} else if (ctx.OR() != null) {
			return new OrExpression(visitExpr(ctx.left), visitExpr(ctx.right));
		} else if (ctx.ASSIGN() != null) {
			BasableExpression left = visitValue(ctx.leftVar);
			if (left instanceof VarExpression) {
				return new AssignExpression((VarExpression)left, visitExpr(ctx.right));
			}
			throw new RuntimeException("Cannot assign values to " + left.getClass().getSimpleName());
		} else if (ctx.value() != null) {
			return visitValue(ctx.value());
		} else if (ctx.constant() != null) {
			return visitConstant(ctx.constant());
		} else {
			return visitExpr(ctx.center);
		}
	}

	@Override
	public MethodExpression visitCall(ExprParser.CallContext ctx) {
		List<Expression> argsList = new ArrayList<Expression>();

		ExprParser.ArgslistContext args = ctx.argslist();
		while (args != null && args.expr() != null) {
			argsList.add(visitExpr(args.expr()));
			args = args.argslist();
		}

		return new MethodExpression(ctx.IDENTIFIER().getText(), argsList.toArray(new Expression[argsList.size()]));
	}

	@Override
	public VarExpression visitVariable(ExprParser.VariableContext ctx) {
		return new VarExpression(null, ctx.NULL() != null ? null : ctx.IDENTIFIER().getText());
	}

	@Override
	public BasableExpression visitValue(ExprParser.ValueContext ctx) {
		if (ctx.DOT() != null) {
			BasableExpression left = visitValue(ctx.left);
			BasableExpression right = visitValue(ctx.right);
			right.setBase(left);
			return right;
		}
		if (ctx.call() != null) {
			return visitCall(ctx.call());
		} else if (ctx.variable() != null) {
			return visitVariable(ctx.variable());
		}
		return null;
	}

	@Override
	public Expression visitResource(ExprParser.ResourceContext ctx) {
		if (ctx.NULL() != null) {
			// null resources
			return new ResourceExpression();
		} else {
			return new ResourceExpression(ctx.getText().substring(1).trim());
		}
	}

	@Override
	public Expression visitConstant(ExprParser.ConstantContext ctx) {
		if (ctx.STRING() != null) {
			return new ConstantExpression(ctx.STRING().getText());
		} else if (ctx.bool() != null) {
			return visitBool(ctx.bool());
		} else if (ctx.resource() != null) {
			return visitResource(ctx.resource());
		} else {
			return null;
		}
	}

	@Override
	public ConstantExpression visitBool(ExprParser.BoolContext ctx) {
		return new ConstantExpression(ctx.TRUE() != null);
	}
}
