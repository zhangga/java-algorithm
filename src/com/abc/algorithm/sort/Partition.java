package com.abc.algorithm.sort;

import java.util.Arrays;

/**
 * 划分
 *
 * @author U-Demon
 */
public class Partition {
	
	/** 待划分的数组 */
	private static int[] arr = new int[] {10, 2, 4, 6, 7, 2, 5, 20, 12, 9};
	
	private static void partitionIt(int left, int right, int pivot) {
		if (left >= right) {
			return;
		}
		while (left < right && arr[left] < pivot) {
			left++;
		}
		while (right > left && arr[right] >= pivot) {
			right--;
		}
		if (left < right && right >= 0) {
			swap(left, right);
		}
		partitionIt(left+1, right-1, pivot);
	}
	
	private static void swap(int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
	
	public static void start() {
		int pivot = 10;
		partitionIt(0, arr.length-1, pivot);
		System.out.println("以中值： " + pivot +"来划分数组，结果。" + Arrays.toString(arr));
	}

}
