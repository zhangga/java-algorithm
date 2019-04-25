package com.abc.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的全排列
 *
 * @author U-Demon
 */
public class Permutation {
	
	private char[] value = new char[] {'A', 'B', 'C'};
	
	private List<String> sequence = null;
	
	public void doPerm() {
		int length = value.length;
		int factorial = doFactorial(length);
		sequence = new ArrayList<>(factorial);
//		doAnagram1(length);
		doAnagram2(0, length-1);
	}
	
	/**
	 * 递归实现1
	 * @param n
	 */
	private void doAnagram1(int n) {
		if (n == 1) {
			return;
		}
		for (int i = 0; i < n; i++) {
			doAnagram1(n - 1);
			if (n == 2) {
				sequence.add(new String(value));
			}
			rotate(n);
		}
	}
	
	/**
	 * 将后N位的字符串旋转，即第一位移到最后。
	 * 例：A B C D  n=3时    结果：A C D B
	 * @param n
	 */
	private void rotate(int n) {
		int position = value.length - n;
		char temp = value[position];
		for (int i = position+1; i < value.length; i++) {
			value[i - 1] = value[i];
			value[i] = temp;
		}
	}
	
	/**
	 * 递归实现2
	 * @param start
	 * @param end
	 */
	private void doAnagram2(int start, int end) {
		if (end <= 1) {
			return;
		}
		if (start == end) {
			sequence.add(new String(value));
		}
		else {
			for (int i = start; i <= end; i++) {
//				if (isSwap(i, start)) { // 判断有重复字符的情况。有bug
					swap(i, start);
					doAnagram2(start + 1, end);
					swap(i, start);
//				}
			}
		}
	}
	
	/**
	 * 交换m和n位置上的值
	 * @param m
	 * @param n
	 */
	private void swap(int m, int n) {
		if (m == n)
			return;
		char temp = value[m];
		value[m] = value[n];
		value[n] = temp;
	}
	
	private boolean isSwap(int begin, int end) {
		for (int i = begin; i < end; i++) {
			if (value[i] == value[end])
				return false;
		}
		return true;
	}
	
	/**
	 * 求阶乘
	 * @param n
	 * @return
	 */
	private int doFactorial(int n) {
		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 1;
		}
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public static void start() {
		Permutation perm = new Permutation();
		perm.doPerm();
		System.out.println("字符串："+ String.valueOf(perm.value) +" 的全排列");
		for (String v : perm.sequence) {
			System.out.println(v);
		}
	}
	
}
