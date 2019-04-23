package com.abc.algorithm.expression;

import com.abc.algorithm.collection.Stack;

/**
 * 计算后缀表达式
 * 只支持单字符，见{@code InToPost}
 *
 * @author U-Demon
 */
public class CalcPost {
	
	// 后缀表达式
	private String post = null;
	
	public static void start() {
		InToPost express = new InToPost("5-(1+3*8)*2");
		express.doTrans();
		String output = express.getOutput();
		CalcPost post = new CalcPost(output);
		double value = post.calcValue();
		System.out.println("计算表达式:  " + express.getInput() + ", 求值->" + value);
	}
	
	public CalcPost(String post) {
		this.post = post;
	}
	
	/**
	 * 计算后缀表达式的值
	 * @return
	 */
	public double calcValue() {
		Stack stack = new Stack(post.length());
		for (int i = 0; i < post.length(); i++) {
			char ch = post.charAt(i);
			// 如果是操作符
			if (isOperator(ch)) {
				double operand2 = Double.valueOf(stack.pop().toString());
				double operand1 = Double.valueOf(stack.pop().toString());
				double value = calcOperands(operand1, operand2, ch);
				stack.push(value);
			}
			else {
				stack.push(ch);
			}
		}
		return stack.pop();
	}
	
	/**
	 * 判断一个字符是否是操作符
	 * @param ch
	 * @return
	 */
	private boolean isOperator(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
			return true;
		}
		return false;
	}
	
	private double calcOperands(double operand1, double operand2, char operator) {
		double value = 0;
		switch (operator) {
		case '+':
			value = operand1 + operand2;
			break;
		case '-':
			value = operand1 - operand2;
			break;
		case '*':
			value = operand1 * operand2;
			break;
		case '/':
			value = operand1 / operand2;
			break;
		default:
			break;
		}
		return value;
	}

}
