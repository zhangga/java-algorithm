package com.abc.algorithm.tree;

/**
 * 2-3-4树
 * @param <E>
 *
 * @author U-Demon
 */
public class Tree234<E extends Comparable<E>> {
	
	// 根节点
	private Node234<E> root;

	public E find(E key) {
		Node234<E> current = root;
		E item;
		while (true) {
			if ((item = current.findItem(key)) != null) {
				return item;
			}
			else if (current.isLeaf()) {
				return null;
			}
			else {
				current = getNextChild(current, key);
			}
		}
	}
	
	public Node234<E> getNextChild(Node234<E> current, E key) {
//		for (int i = 0; i < current.size; i++) {
//			if (current[E])
//		}
		return null;
	}

	public Node234<E> root() {
		return root;
	}

}
