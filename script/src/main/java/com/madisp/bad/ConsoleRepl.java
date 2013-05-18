package com.madisp.bad;

import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.BadScope;
import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/18/13
 * Time: 6:25 PM
 */
public class ConsoleRepl {
	public static void main(String[] args) throws IOException {
		ExpressionFactory factory = new ExpressionFactory();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Repl running, type 'exit' to quit.");
		BadScope scope = new BadScope(null, new Object());
		String s;
		while (!(s = getLine(reader)).equals("exit")) {
			if (s.isEmpty()) {
				continue;
			}
			try {
				Expression expr = factory.buildExpression(s);
				System.out.println(BadConverter.string(expr.value(scope)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String getLine(BufferedReader reader) throws IOException {
		System.out.print("> ");
		System.out.flush();
		return reader.readLine().trim();
	}
}
