package com.abc.algorithm;

import com.abc.algorithm.collection.PriorityQueue;
import com.abc.algorithm.collection.SortedList;
import com.abc.algorithm.expression.CalcPost;
import com.abc.algorithm.expression.InToPost;
import com.abc.algorithm.recursive.Bag;
import com.abc.algorithm.recursive.Compose;
import com.abc.algorithm.recursive.Permutation;
import com.abc.algorithm.recursive.Power;
import com.abc.algorithm.recursive.Towers;
import com.abc.algorithm.recursive.Triangle;
import com.abc.algorithm.sort.BubbleSort;
import com.abc.algorithm.sort.InsertSort;
import com.abc.algorithm.sort.MergeSort;
import com.abc.algorithm.sort.SelectSort;

public class Main {
	
	public static void main(String[] args) {
		// 冒泡排序
		BubbleSort.start();
		// 选择排序
		SelectSort.start();
		// 插入排序
		InsertSort.start();
		// 归并排序
		MergeSort.start();
		// 优先级队列
		PriorityQueue.start();
		// 后缀表达式
		InToPost.start();
		// 计算表达式
		CalcPost.start();
		// 有序列表
		SortedList.start();
		// 三角数字
		Triangle.start();
		// 字符串的全排列
		Permutation.start();
		// 字符串的组合
		Compose.start();
		// 汉诺塔问题
		Towers.start();
		// 乘方计算
		Power.start();
		// 背包问题
		Bag.start();
	}

}
