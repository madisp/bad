package com.madisp.bad.expr;

import com.madisp.bad.eval.BadScope;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/12/13
 * Time: 3:24 PM
 */
public class BlockExpression implements Expression {
	private final Expression expr;
	private List<String> vars;

	public BlockExpression(Expression expression, List<String> vars) {
		this.vars = vars;
		this.expr = expression;
	}

	@Override
	public Object value(Scope scope) {
		return this;
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
	}

	public Object yield(Scope scope, Object... args) {
		BadScope execScope = new BadScope(null, new Object());
		for (int i = 0; i < Math.min(args.length, vars.size()); i++) {
			execScope.setVar(null, vars.get(i), args[i]);
		}
		execScope.setParent(scope);
		return expr.value(execScope);
	}
}
