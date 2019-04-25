package com.abc.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 采用划分的思想，数组划分成两个子数组，左数组小于基值，右数组大于基值
 *
 * @author U-Demon
 */
public class QuickSort {
	
	/** 待排序数据 */
	private static int[] arr = new int[] {10, 2, 4, 6, 7, 2, 5, 20, 12, 9};
	
	/**
	 * 递归实现
	 * @param left
	 * @param right
	 */
	public static void recQuickSort(int left, int right) {
		if (left >= right) {
			return;
		}
		else {
			int partition = partition(left, right);
			recQuickSort(left, partition-1);
			recQuickSort(partition+1, right);
		}
	}
	
	/**
	 * 划分
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int left, int right) {
		int middle = (left + right) / 2;
		int pivot = arr[middle];
		return recPartition(left, right, pivot);
	}
	
	private static int recPartition(int left, int right, int pivot) {
		if (left >= right) {
			return left;
		}
		while (left < right && arr[left] < pivot) {
			left++;
		}
		while (right > left && arr[right] > pivot) {
			right--;
		}
		swap(left, right);
		return recPartition(left+1, right-1, pivot);
	}
	
	private static void swap(int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
	
	public static void start() {
		recQuickSort(0, arr.length - 1);
		System.out.println("快速排序： " + Arrays.toString(arr));
	}

}
