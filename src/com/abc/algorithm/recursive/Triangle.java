package com.abc.algorithm.recursive;

/**
 * 三角数字
 * 1 3 6 10 15 21 ...
 * 第N项的值=N+第N-1项的值
 *
 * @author U-Demon
 */
public class Triangle {
	
	/**
	 * 获取第N项三角数字的值
	 * 非递归
	 * @param n
	 * @return
	 */
	public static int getTriangle(int n) {
		int num = 0;
		while (n > 0) {
			num += n;
			n--;
		}
		return num;
	}
	
	/**
	 * 获取第N项三角数字的值
	 * 递归
	 * @param n
	 * @return
	 */
	public static int getTriangleRecursive(int n) {
//		System.out.println("Entering: n="+n);
		// 基值情况 base case
		if (n == 1) {
//			System.out.println("Returning 1");
			return 1;
		}
		int temp = getTriangleRecursive(n-1) + n;
//		System.out.println("Returning " + temp);
		return temp;
	}
	
	public static void start() {
		System.out.println("非递归获取三角数字，第6项的值=" + getTriangle(6));
		System.out.println("递归获取三角数字，第6项的值=" + getTriangleRecursive(6));
	}

}
