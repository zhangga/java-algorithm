package com.abc.algorithm;

import com.abc.algorithm.collection.PriorityQueue;
import com.abc.algorithm.collection.SortedList;
import com.abc.algorithm.expression.CalcPost;
import com.abc.algorithm.expression.InToPost;
import com.abc.algorithm.sort.BubbleSort;
import com.abc.algorithm.sort.InsertSort;
import com.abc.algorithm.sort.SelectSort;

public class Main {
	
	public static void main(String[] args) {
		// 冒泡排序
		BubbleSort.start();
		// 选择排序
		SelectSort.start();
		// 插入排序
		InsertSort.start();
		// 优先级队列
		PriorityQueue.start();
		// 后缀表达式
		InToPost.start();
		// 计算表达式
		CalcPost.start();
		// 有序列表
		SortedList.start();
	}

}
