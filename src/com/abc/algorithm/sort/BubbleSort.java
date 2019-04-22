package com.abc.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * O(N^2)
 * @author Administrator
 *
 */
public class BubbleSort {

	public static void start() {
		sort();
		System.out.println("冒泡排序: " + Arrays.toString(arr));
	}
	
	/** 待排序数据 */
	private static int[] arr = new int[] {10, 2, 4, 6, 7, 2, 5};
	
	/**
	 * 排序
	 */
	private static void sort() {
		// 每趟排序，最右边的数确定为最大的
		for (int right = arr.length-1; right > 1; right--) {
			for (int i = 0; i < right; i++) {
				// 后者比前者小
				if (arr[i+1] < arr[i]) {
					// 交换
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
	}
	
}
