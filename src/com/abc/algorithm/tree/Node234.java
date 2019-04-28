package com.abc.algorithm.tree;

/**
 * 2-3-4树节点
 * @param <E>
 *
 * @author U-Demon
 */
public class Node234<E extends Comparable<E>> {
	
	/** 节点数据最大值 */
	private static final int ITEM_MAX = 3;
	
	/** 节点数据 */
	Object[] datas = new Object[ITEM_MAX];
	/** 节点数据当前长度 */
	int size = 0;
	
	/** 子节点，最大值为ITEM_MAX+1 */
	@SuppressWarnings("unchecked")
	Node234<E>[] children = new Node234[ITEM_MAX+1];
	
	Node234<E> parent;
	
	public Node234() {
		
	}
	
	@SuppressWarnings("unchecked")
	public E findItem(E key) {
		for (int i = 0; i < ITEM_MAX; i++) {
			Object data = datas[i];
			if (data == null) {
				return null;
			}
			else if (key.compareTo((E) data) == 0) {
				return (E) data;
			}
		}
		return null;
	}
	
	public void connectChild(int childIndex, Node234<E> child) {
		children[childIndex] = child;
		if (child != null) {
			child.parent = this;
		}
	}
	
	public Node234<E> disconnectChild(int childIndex) {
		Node234<E> temp = children[childIndex];
		children[childIndex] = null;
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	public boolean insert(E data) {
		if (size == 0) {
			datas[0] = data;
			size++;
			return true;
		}
		else if (size < ITEM_MAX) {
			// 插入合适位置
			int i = size;
			while (--i >= 0 && data.compareTo((E) datas[i]) < 0) {
				datas[i+1] = datas[i];
			}
			datas[i+1] = data;
			size++;
			return true;
		}
		// 先分裂
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public E removeItem() {
		E temp = (E) datas[size - 1];
		datas[size - 1] = null;
		size--;
		return temp;
	}
	
	/**
	 * 节点是否满
	 * @return
	 */
	public boolean isFull() {
		return size >= ITEM_MAX;
	}
	
	/**
	 * 是否叶节点
	 * @return
	 */
	public boolean isLeaf() {
		return children[0] == null;
	}

	@Override
	public String toString() {
		return datas.toString();
	}

}
