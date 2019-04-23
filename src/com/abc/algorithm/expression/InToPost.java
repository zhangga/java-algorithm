package com.abc.algorithm.expression;

import com.abc.algorithm.collection.Stack;

/**
 * 中缀表达式转后缀表达式
 * 简单的只支持单字符，也就是小于10的
 * 扩展方式：使用单字母映射对应的值。或者解析连续的数字
 *
 * @author U-Demon
 */
public class InToPost {
	
	private Stack stack;
	
	private String input;
	
	private StringBuilder output = null;
	
	public InToPost(String infix) {
		input = infix;
		int stackSize = input.length();
		stack = new Stack(stackSize);
	}
	
	/**
	 * 转换
	 * @return
	 */
	public void doTrans() {
		output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				stack.push(ch);
				break;
			case ')':
				gotParent(ch);
				break;
			default:
				output.append(ch);
				break;
			}
		}
		while (!stack.isEmpty()) {
			output.append((char)stack.pop());
		}
	}
	
	private void gotOper(char opThis, int precThis) {
		while (!stack.isEmpty()) {
			char opTop = stack.pop();
			if (opTop == '(') {
				stack.push(opTop);
				break;
			}
			else {
				int precTop;
				if (opTop == '+' || opTop == '-') {
					precTop = 1;
				}
				else {
					precTop = 2;
				}
				if (precTop < precThis) {
					stack.push(opTop);
					break;
				}
				else {
					output.append(opTop);
				}
			}
		}
		stack.push(opThis);
	}
	
	private void gotParent(char ch) {
		while (!stack.isEmpty()) {
			char chx = stack.pop();
			if (chx == '(')
				break;
			else
				output.append(chx);
		}
	}
	
	public String getOutput() {
		return output.toString();
	}
	
	public String getInput() {
		return input;
	}

	public static void start() {
		InToPost express = new InToPost("A-(B+C)*D");
		express.doTrans();
		System.out.println("前缀表达式-> " + express.input + "后缀表达式-> " + express.output.toString());
	}

}
