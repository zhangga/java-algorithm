package com.abc.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 假设一个标识位的左边是排好序的数组，右边是未排序的数据，
 * 只需要从标志位开始依次将右边的未排序的数据插入到左边已排序数组的合适位置即可
 * O(N^2)
 * @author Administrator
 *
 */
public class InsertSort {
	
	public static void start() {
		sort();
		System.out.println("插入排序: " + Arrays.toString(arr));
	}
	
	/** 待排序数据 */
	private static int[] arr = new int[] {10, 2, 4, 6, 7, 2, 5};
	
	/**
	 * 排序
	 */
	private static void sort() {
		// 每趟排序，middle左边的都是排好序的，将middle找到正确的位置插入
		for (int middle = 1; middle < arr.length; middle++) {
			int temp = arr[middle]; 
			int i = middle;
			while (i > 0 && arr[i-1] > temp) {
				arr[i] = arr[i-1];
				i--;
			}
			arr[i] = temp;
		}
	}

}
