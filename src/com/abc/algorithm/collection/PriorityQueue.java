package com.abc.algorithm.collection;

import java.util.Arrays;

/**
 * 优先级队列
 * 队首->队尾: 从大到小
 * @author U-Demon
 */
public class PriorityQueue {
	
	/** 队列，使用数组实现 */
	private int[] queue;
	/** 当前队列中元素个数 */
	private int nItems;
	
	public PriorityQueue(int size) {
		queue = new int[size];
		nItems = 0;
	}
	
	/**
	 * 插入元素
	 * @param item
	 */
	public void insert(int item) {
		if (nItems == 0) {
			queue[nItems++] = item;
		}
		else {
			int index = -1;
			for (int i = nItems - 1; i >= 0; i--) {
				if (queue[i] < item) {
					queue[i+1] = queue[i];
				}
				else {
					index = i;
					break;
				}
			}
			queue[index+1] = item;
			nItems++;
		}
	}
	
	public int remove() {
		return queue[--nItems];
	}
	
	public int peekMin() {
		return queue[nItems-1];
	}
	
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public boolean isFull() {
		return nItems == queue.length;
	}
	
	public void print() {
		System.out.println("队列数据-> "+Arrays.toString(queue));
	}
	
	public static void start() {
		// 10, 2, 4, 6, 7, 2, 5
		PriorityQueue queue = new PriorityQueue(10);
		queue.insert(10);
		queue.insert(2);
		queue.insert(4);
		queue.insert(6);
		queue.insert(7);
		queue.insert(2);
		queue.insert(5);
		queue.print();
	}

}
