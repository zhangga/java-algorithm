package com.abc.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * O(N^2)
 * @author Administrator
 *
 */
public class SelectSort {
	
	public static void start() {
		sort();
		System.out.println("选择排序: " + Arrays.toString(arr));
	}
	
	/** 待排序数据 */
	private static int[] arr = new int[] {10, 2, 4, 6, 7, 2, 5};
	
	/**
	 * 排序
	 */
	private static void sort() {
		// 每趟排序，最左边的数确定为最小的
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			// 将最小值交换到最左边
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}

}
