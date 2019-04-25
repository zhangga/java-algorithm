package com.abc.algorithm.tree;

import java.util.Map;

/**
 * 二叉树
 *
 * @author U-Demon
 */
public class BinaryTree<E extends Comparable<E>> implements Tree<E> {
	
	// 根节点
	private Node<E> root;

	/**
	 * 查找
	 */
	@Override
	public Node<E> find(E key) {
		if (key == null) {
			return null;
		}
		
		Node<E> current = root;
		while (current != null) {
			E data = current.data;
			int c = key.compareTo(data);
			// 相等
			if (c == 0) {
				return current;
			}
			else if (c < 0) {
				current = current.leftChild;
			}
			else {
				current = current.rightChild;
			}
		}
		return null;
	}
	
	/**
	 * 插入节点
	 */
	@Override
	public boolean insert(E data) {
		if (data == null) {
			return false;
		}
		
		Node<E> newNode = new Node<E>(data);
		return insert(newNode);
	}
	
	public boolean insert(Node<E> newNode) {
		if (newNode == null) {
			return false;
		}
		
		// 根节点
		if (root == null) {
			root = newNode;
			return true;
		}
		else {
			Node<E> current = root;
			while (current != null) {
				int c = newNode.getData().compareTo(current.data);
				// 插入值比当前值大，搜索右节点
				if (c >= 0) {
					// 右节点为空，插入
					if (current.rightChild == null) {
						current.rightChild = newNode;
						return true;
					}
					current = current.rightChild;
				}
				else {
					// 左节点为空，插入
					if (current.leftChild == null) {
						current.leftChild = newNode;
						return true;
					}
					current = current.leftChild;
				}
			}
		}
		return false;
	}
	
	public boolean insert(Node<E> newNode, boolean left) {
		if (newNode == null) {
			return false;
		}
		
		// 根节点
		if (root == null) {
			root = newNode;
			return true;
		}
		
		// 左节点
		if (left) {
			root.leftChild = newNode;
		}
		// 右节点
		else {
			root.rightChild = newNode;
		}
		return true;
	}

	@Override
	public boolean delete(E key) {
		Node<E> current = root;
        Node<E> parent = root;
        boolean isLeftChild = false;
        int c = current.data.compareTo(key);
        // 查找删除值，找不到直接返回false
        while(c != 0){
            parent = current;
            if(c > 0){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){
                return false;
            }
        }
        //如果当前节点没有子节点
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
            return true;
             
            //当前节点有一个子节点，右子节点
        }else if(current.leftChild == null && current.rightChild != null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
            return true;
            //当前节点有一个子节点，左子节点
        }else if(current.leftChild != null && current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
            return true;
        }else{
            //当前节点存在两个子节点
            Node<E> successor = getSuccessor(current);
            if(current == root){
                root= successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;
	}
	
	/**
	 * 获取后继节点
	 * @param delNode
	 * @return
	 */
	public Node<E> getSuccessor(Node<E> delNode) {
		Node<E> successorParent = delNode;
        Node<E> successor = delNode;
        Node<E> current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
         
        return successor;
	}
	
	/**
	 * 中序遍历
	 */
	@Override
	public void infixOrder(Node<E> current) {
		if (current != null) {			
			infixOrder(current.leftChild);
			System.out.print(current+", ");
			infixOrder(current.rightChild);
		}
	}
	
	/**
	 * 前序遍历
	 */
	@Override
	public void preOrder(Node<E> current) {
		if (current != null) {			
			System.out.print(current+", ");
			preOrder(current.leftChild);
			preOrder(current.rightChild);
		}
	}

	/**
	 * 后序遍历
	 */
	@Override
	public void postOrder(Node<E> current) {
		if (current != null) {			
			postOrder(current.leftChild);
			postOrder(current.rightChild);
			System.out.print(current+", ");
		}
	}

	@Override
	public Node<E> findMax() {
		if (root == null) {
			return null;
		}
		
		Node<E> current = root;
		while (current.rightChild != null) {
			current = current.rightChild;
		}
		return current;
	}

	@Override
	public Node<E> findMin() {
		if (root == null) {
			return null;
		}
		
		Node<E> current = root;
		while (current.leftChild != null) {
			current = current.leftChild;
		}
		return current;
	}
	
	/**
	 * 遍历节点的路径信息，左节点0,右节点1
	 * 前序遍历/中序/后续都OK
	 * @param map
	 * @param root
	 * @param path
	 */
	public void scanNodePath(Map<String, Node<E>> map, Node<E> root, StringBuilder path) {
		if (map == null) {
			return;
		}
		if (root == null) {
			// 路径退格
			path.deleteCharAt(path.length() - 1);
			return;
		}
		// 根节点
		if (path == null) {
			path = new StringBuilder();
		}
		map.put(path.toString(), root);
		scanNodePath(map, root.leftChild, path.append("0"));
		scanNodePath(map, root.rightChild, path.append("1"));
		if (path.length() > 0) {			
			path.deleteCharAt(path.length() - 1);		
		}
	}

	@Override
	public Node<E> root() {
		return root;
	}

}
