package com.abc.algorithm;

import java.util.Arrays;

import com.abc.algorithm.collection.PriorityQueue;
import com.abc.algorithm.collection.PriorityQueueHeap;
import com.abc.algorithm.collection.SortedList;
import com.abc.algorithm.expression.CalcPost;
import com.abc.algorithm.expression.InToPost;
import com.abc.algorithm.graph.Graph;
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
		// 图
		graph();
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
	
	private static void graph() {
		// 无向图
		Graph<String> graph = new Graph<>(5);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		System.out.print("深度优先搜索dfs: ");
		graph.dfs();
		System.out.println();
		System.out.print("广度优先搜索bfs: ");
		graph.bfs();
		System.out.println();
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		System.out.print("最小生成树: ");
		graph.mst();
		System.out.println();
		
		// 有向图的拓扑
		graph = new Graph<>(8);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addEdgeDir(0, 3);
		graph.addEdgeDir(0, 4);
		graph.addEdgeDir(3, 6);
		graph.addEdgeDir(4, 6);
		graph.addEdgeDir(1, 4);
		graph.addEdgeDir(6, 7);
		graph.addEdgeDir(2, 5);
		graph.addEdgeDir(5, 7);
		graph.topo();
		
		// 有向图的连通性
		graph = new Graph<>(5);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addEdgeDir(0, 2);
		graph.addEdgeDir(1, 0);
		graph.addEdgeDir(1, 4);
		graph.addEdgeDir(4, 2);
		graph.addEdgeDir(3, 4);
		int[][] mat = graph.warshall();
		System.out.println("有向图的连通性: ");
		for (int[] ms : mat) {
			System.out.println(Arrays.toString(ms));
		}
		
		// 无向带权图最小生成树
		graph = new Graph<>(6);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addEdgeWeight(0, 1, 6);
		graph.addEdgeWeight(0, 3, 4);
		graph.addEdgeWeight(1, 2, 10);
		graph.addEdgeWeight(1, 3, 7);
		graph.addEdgeWeight(1, 4, 7);
		graph.addEdgeWeight(3, 2, 8);
		graph.addEdgeWeight(3, 4, 12);
		graph.addEdgeWeight(2, 4, 5);
		graph.addEdgeWeight(2, 5, 6);
		graph.addEdgeWeight(4, 5, 7);
		System.out.println(graph.mstw());
		
		// 带权图最短路径
		graph = new Graph<>(5);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addEdgeDirW(0, 1, 50);
		graph.addEdgeDirW(0, 3, 80);
		graph.addEdgeDirW(1, 2, 60);
		graph.addEdgeDirW(1, 3, 90);
		graph.addEdgeDirW(2, 4, 40);
		graph.addEdgeDirW(3, 2, 20);
		graph.addEdgeDirW(3, 4, 70);
		graph.addEdgeDirW(4, 1, 50);
		graph.dijkstra();
	}

}
