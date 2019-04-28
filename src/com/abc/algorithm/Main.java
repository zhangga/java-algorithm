package com.abc.algorithm;

import com.abc.algorithm.collection.PriorityQueue;
import com.abc.algorithm.collection.PriorityQueueHeap;
import com.abc.algorithm.collection.SortedList;
import com.abc.algorithm.expression.CalcPost;
import com.abc.algorithm.expression.InToPost;
import com.abc.algorithm.huffman.Huffman;
import com.abc.algorithm.recursive.Bag;
import com.abc.algorithm.recursive.Compose;
import com.abc.algorithm.recursive.Permutation;
import com.abc.algorithm.recursive.Power;
import com.abc.algorithm.recursive.Towers;
import com.abc.algorithm.recursive.Triangle;
import com.abc.algorithm.sort.BaseSort;
import com.abc.algorithm.sort.BubbleSort;
import com.abc.algorithm.sort.InsertSort;
import com.abc.algorithm.sort.MergeSort;
import com.abc.algorithm.sort.Partition;
import com.abc.algorithm.sort.QuickSort;
import com.abc.algorithm.sort.SelectSort;
import com.abc.algorithm.sort.ShellSort;
import com.abc.algorithm.tree.BinaryTree;
import com.abc.algorithm.tree.Tree;

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
		// 希尔排序
		ShellSort.start();
		// 划分
		Partition.start();
		// 快速排序
		QuickSort.start();
		// 基数排序
		BaseSort.start();
		// 优先级队列
		PriorityQueue.start();
		PriorityQueueHeap.start();
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
		// 二叉树
		testTree();
		// 哈夫曼
		huffman();
	}
	
	private static void testTree() {
		Tree<Integer> tree = new BinaryTree<>();
		tree.insert(3);
		tree.insert(2);
		tree.insert(5);
		tree.insert(6);
		tree.insert(4);
		System.out.println("前序遍历：");
		tree.preOrder(tree.root());
		System.out.println("\n中序遍历：");
		tree.infixOrder(tree.root());
		System.out.println("\n后序遍历：");
		tree.postOrder(tree.root());
		System.out.println("\n当前的最大值：" + tree.findMax());
		System.out.println("当前的最小值：" + tree.findMin());
		tree.delete(3);
		System.out.println("前序遍历：");
		tree.preOrder(tree.root());
		System.out.print("\n");
	}
	
	private static void huffman() {
		Huffman huffman = new Huffman("This is my huffman test!");
//		Huffman huffman = new Huffman("aaabbc");
		huffman.encoding();
	}

}
