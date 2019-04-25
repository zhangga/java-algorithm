package com.abc.algorithm.recursive;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 背包问题
 * 容量为20磅的背包，怎么恰好放入物品11 8 7 6 5磅
 *
 * @author U-Demon
 */
public class Bag {
	
	/** 容量 */
	private int capacity = 20;
	
	/** 物品，这里假设物品已经从大到小排序好了 */
	private int[] items = new int[] {11, 10, 8, 7, 6, 5, 4};
	
	/** 栈：记录查找结果的过程 */
	private LinkedList<Integer> result = new LinkedList<>();
	
	public void compute() {
		recPutIn(0, capacity);
	}
	
	/**
	 * 从索引index开始向后，寻找满足容量为cap的组合
	 * @param index
	 * @param cap
	 */
	private void recPutIn(int index, int cap) {
		if (index >= items.length) {
			if (result.isEmpty()) {
				return;
			}
			int last = result.removeLast();
			cap += items[last];
			recPutIn(last+1, cap);
			return;
		}
		int left = cap - items[index];
		if (left < 0) {
			recPutIn(index + 1, cap);
		}
		else if (left > 0) {
			result.addLast(index);
			// 所有剩余的和加起来都不满足，再也没有可能得情况了，终止判断、
			if (index == items.length - 1 && result.getFirst()+result.size() == items.length) {
				return;
			}
			recPutIn(index + 1, left);
		}
		else {
			// 查找的结果
			result.addLast(index);
			System.out.println("结果：" + Arrays.toString(result.toArray()));
			// 继续向下找
			int last = result.removeLast();
			left += items[last];
			recPutIn(last+1, left);
		}
	}
	
	public static void start() {
		Bag bag = new Bag();
		bag.compute();
	}

}
