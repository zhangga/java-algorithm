package com.abc.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 采用h = 3*h + 1的增量进行插入排序
 *
 * @author U-Demon
 */
public class ShellSort {
	
	/** 待排序数据 */
	private static int[] arr = new int[] {10, 2, 4, 6, 7, 2, 5, 20, 12, 9};
	
	public static void sort() {
		int h = 1;
		while (h*3 < arr.length) {
			h = h*3 + 1;
		}
		
		int outer, inner;
		while (h > 0) {
			for (outer = h; outer < arr.length; outer++) {
				int temp = arr[outer];
				inner = outer;
				while (inner > h-1 && arr[inner-h] >= temp) {
					arr[inner] = arr[inner-h];
					inner -= h;
				}
				arr[inner] = temp;
			}
			h = (h-1) / 3;
		}
	}
	
	public static void start() {
		ShellSort.sort();
		System.out.println("希尔排序： " + Arrays.toString(arr));
	}

}
