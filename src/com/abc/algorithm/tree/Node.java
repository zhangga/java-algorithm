package com.abc.algorithm.tree;

/**
 * 树的节点
 * @param <E>
 *
 * @author U-Demon
 */
public class Node<E> {
	
	/** 节点数据 */
	E data;
	/** 左子节点 */
	Node<E> leftChild;
	/** 右子节点 */
	Node<E> rightChild;
	
	public Node(E data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public E getData() {
		return data;
	}

}
