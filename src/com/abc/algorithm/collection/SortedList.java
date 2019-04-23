package com.abc.algorithm.collection;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 有序列表
 * 从小到大
 * @param <E>
 *
 * @author U-Demon
 */
public class SortedList<E extends Comparable<E>> {
	
	private LinkedList<E> list = new LinkedList<>();
	
	public boolean isEmpty() {
		return list.getFirst() == null;
	}
	
	/**
	 * 插入
	 * @param element
	 */
	public void insert(E element) {
		int index = 0;
		Iterator<E> ite = list.iterator();
		while (ite.hasNext()) {
			E item = ite.next();
			if (item.compareTo(element) > 0) {
				list.add(index, element);
				return;
			}
			index++;
		}
		list.add(index, element);
	}
	
	public E removeFirst() {
		return list.removeFirst();
	}
	
	public E removeLast() {
		return list.removeLast();
	}
	
	public static void start() {
		SortedList<Integer> list = new SortedList<>();
		list.insert(10);
		list.insert(2);
		list.insert(6);
		list.insert(7);
		list.insert(2);
		list.insert(5);
		list.insert(4);
		System.out.println("有序列表："+list.toString());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Iterator<E> ite = list.iterator();
		while (ite.hasNext()) {
			E item = ite.next();
			sb.append(item.toString()).append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
