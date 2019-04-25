package com.abc.algorithm.tree;

/**
 * 树
 *
 * @author U-Demon
 */
public interface Tree<E extends Comparable<E>> {

	// 查找节点
	public Node<E> find(E key);
	
	// 插入新节点
	public boolean insert(E data);
	
	// 删除节点
	public boolean delete(E key);
	
	// 中序遍历
	public void infixOrder(Node<E> current);
	// 前序遍历
	public void preOrder(Node<E> current);
	// 后续遍历
	public void postOrder(Node<E> current);
	
	// 查找最大值
	public Node<E> findMax();
	// 查找最小值
	public Node<E> findMin();
	
	public Node<E> root();
	
}
