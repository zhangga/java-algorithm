package com.abc.algorithm.collection;

/**
 * 优先级队列，使用堆实现。降序，保存最大值
 * 堆：弱序，父节点大于两个子节点。
 * 堆即完全二叉树的结构，数组实现，无洞。
 *
 * @author U-Demon
 */
public class PriorityQueueHeap {
	
	/** 数组表示完全二叉树 */
	private int[] heap;
	
	/** 当前元素长度 */
	private int size;
	
	public PriorityQueueHeap(int size) {
		this.heap = new int[size];
		this.size = 0;
	}
	
	/**
	 * 插入
	 * @param value
	 */
	public void insert(int value) {
		if (isFull()) {
			int[] arr = new int[this.size << 1];
			System.arraycopy(heap, 0, arr, 0, this.size);
			this.heap = arr;
		}
		this.heap[size++] = value;
		if (size == 1) {
			return;
		}
		int temp = this.heap[size-1];
		// 上浮
		int index= size - 1;
		while (index > 0) {
			int parent = (index-1) / 2;
			if (temp > this.heap[parent]) {
				this.heap[index] = this.heap[parent];
				index = parent;
			}
			else {
				break;
			}
		}
		this.heap[index] = temp;
	}
	
	public int peekMax() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return this.heap[0];
	}
	
	public int popMax() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int value = this.heap[0];
		this.heap[0] = this.heap[--this.size];
		// 下沉
		int temp = this.heap[0];
		int i = 0;
		int largeChild = 0;
		while (i < this.size / 2) {
			int left = i*2 + 1;
			int right = left + 1;
			if (right < this.size && this.heap[right] > this.heap[left]) {
				largeChild = right;
			}
			else {
				largeChild = left;
			}
			if (temp >= this.heap[largeChild]) {
				break;
			}
			else {
				this.heap[i] = this.heap[largeChild];
				i = largeChild;
			}
		}
		this.heap[i] = temp;
		return value;
	}
	
	public boolean isFull() {
		return this.size >= this.heap.length;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public static void start() {
		// 10, 2, 4, 6, 7, 2, 5
		PriorityQueueHeap queue = new PriorityQueueHeap(10);
		queue.insert(2);
		queue.insert(4);
		queue.insert(10);
		queue.insert(6);
		queue.insert(7);
		queue.insert(20);
		queue.insert(5);
		System.out.println(queue.peekMax());
		System.out.println(queue.popMax());
	}

}
