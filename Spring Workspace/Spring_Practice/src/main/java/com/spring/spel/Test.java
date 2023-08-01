package com.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Hello Tanveer'");
		String message = (String) expression.getValue();
		System.out.println(message);
		//concat method
		System.out.println(parser.parseExpression("'Tanveer '.concat('Ali')").getValue());
		System.out.println(parser.parseExpression("'Java'.bytes").getValue());
		System.out.println(parser.parseExpression("'tanveer'.toUpperCase()").getValue());
		System.out.println(parser.parseExpression("'Tanveer'+'Hussain'").getValue());
		System.out.println(parser.parseExpression("'Today Date '+new java.util.Date()").getValue());
	}

}
/*
 * SpEL is an expression language supporting the features of 
 * querying and manipulating an object graph at runtime.
 */