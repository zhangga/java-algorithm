package com.abc.algorithm.collection;

/**
 * 栈
 *
 * @author U-Demon
 */
public class Stack {
	
	/** 数组 */
	private Object[] arr;
	
	/** 栈顶索引 */
	private int top = -1;
	
	public Stack(int size) {
		arr = new Object[size];
	}
	
	/**
	 * 推入栈中
	 * @param item
	 */
	public void push(Object item) {
		if (isFull()) {
			System.out.println("Stack is full!");
			return;
		}
		arr[++top] = item;
	}
	
	/**
	 * 从栈中弹出元素
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T pop() {
		if (top == -1) {
			return null;
		}
		return (T)arr[top--];
	}
	
	@SuppressWarnings("unchecked")
	public <T> T peek() {
		if (top == -1) {
			return null;
		}
		return (T)arr[top];
	}
	
	public int size() {
		return this.top + 1;
	}
	
	public boolean isFull() {
		return this.top == arr.length - 1;
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Object o;
		while ((o = pop()) != null) {
			sb.append(o.toString()).append(", ");
		}
		return sb.toString();
	}

}
