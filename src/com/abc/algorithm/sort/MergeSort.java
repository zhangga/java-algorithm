package com.abc.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 分治思想
 *
 * @author U-Demon
 */
public class MergeSort {
	
	/** 待排序数据 */
	private static int[] arr = new int[] {10, 2, 4, 6, 7, 2, 5};
	
	/**
	 * 排序
	 */
	private static void sort() {
		int[] workSpace = new int[arr.length];
		recMergeSort(workSpace, 0, arr.length-1);
	}
	
	private static void recMergeSort(int[] workSpace, int lower, int upper) {
		if (lower >= upper) {
			return;
		}
		else {
			int mid = (lower + upper) / 2;
			recMergeSort(workSpace, lower, mid);
			recMergeSort(workSpace, mid+1, upper);
			merge(workSpace, lower, mid+1, upper);
		}
	}
	
	private static void merge(int[] workSpace, int lower, int high, int upper) {
		int num = upper - lower + 1;
		int lowerIndex = lower;
		// 将lower到high-1 和 high到upper合并到workSpace
		int i = 0;
		int mid = high - 1;
		while (lower <= mid && high <= upper) {
			if (arr[lower] < arr[high]) {
				workSpace[i++] = arr[lower++];
			}
			else {
				workSpace[i++] = arr[high++];
			}
		}
		while (lower <= mid) {
			workSpace[i++] = arr[lower++];
		}
		while (high <= upper) {
			workSpace[i++] = arr[high++];
		}
		
		// 将workspace覆盖arr
		for (int j = 0; j < num; j++) {
			arr[lowerIndex++] = workSpace[j];
		}
	}
	
	public static void start() {
		MergeSort.sort();
		System.out.println("归并排序： " + Arrays.toString(arr));
	}

}
