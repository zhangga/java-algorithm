package com.abc.algorithm.huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.abc.algorithm.tree.BinaryTree;
import com.abc.algorithm.tree.Node;

/**
 * 哈夫曼编码
 *
 * @author U-Demon
 */
public class Huffman {
	
	/** 字符串 */
	private String text;
	
	/** 编码后 */
	private String encode;
	
	/** 解码后 */
	private String decode;
	
	/** 哈夫曼数 */
	private BinaryTree<HuffmanNode> tree;
	
	/** 哈夫曼编码表 */
	private Map<Character, String> encodeMap;
	/** 哈夫曼解码表 */
	private Map<String, Character> decodeMap;
	
	public Huffman(String text) {
		this.text = text;
	}
	
	/**
	 * 编码
	 */
	public void encoding() {
		// 统计字符出现频率
		PriorityQueue<Node<HuffmanNode>> cf = statisChar();
		System.out.println("哈夫曼字符出现频率："+cf);
		// 创建哈夫曼数
		createTree(cf);
		// 创建哈夫曼编码表
		createMap();
		// 对字符串进行哈夫曼编码
		doEncoding();
		// 对哈夫曼编码进行解码
		doDecode();
	}
	
	/**
	 * 编码
	 */
	private void doEncoding() {
		StringBuilder sb = new StringBuilder();
		// 编码
		for (int i = 0; i < text.length(); i++) {
			Character ch = text.charAt(i);
			String code = encodeMap.get(ch);
			sb.append(code);
		}
		encode = sb.toString();
		System.out.println("字符串：" + text + " 编码后：" + encode);
	}
	
	/**
	 * 解码
	 */
	private void doDecode() {
		StringBuilder decodeValue = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		int index = 0;
		// 逐个解码
		while (index < encode.length()) {
			sb.append(encode.charAt(index));
			Character value = decodeMap.get(sb.toString());
			// 解码成功
			if (value != null) {
				decodeValue.append(value);
				// 重置
				sb = new StringBuilder();
			}
			index++;
		}
		decode = decodeValue.toString();
		System.out.println("编码：" + encode + " 解码后：" + decode);
	}
	
	/**
	 * 创建哈夫曼树
	 */
	private void createTree(PriorityQueue<Node<HuffmanNode>> cf) {
		BinaryTree<HuffmanNode> btree = null;
		while (cf.size() > 1) {
			// 这里不是二叉搜索数，每次把新节点作为根节点，小的节点作为左节点，大的为右节点
			btree = new BinaryTree<>();
			// 从优先级队列中删掉两个
			Node<HuffmanNode> node1 = cf.poll();
			Node<HuffmanNode> node2 = cf.poll();
			// 组成新的节点
			HuffmanNode newNode = new HuffmanNode(null, node1.getData().f+node2.getData().f);
			Node<HuffmanNode> root = new Node<HuffmanNode>(newNode);
			// 新节点是那俩节点的根节点，因为新节点的F是他们的和，意为着比他们都大
			btree.insert(root);
			btree.insert(node1, true);
			btree.insert(node2, false);
			// 将新节点重新加入优先级队列
			cf.add(root);
		}
		tree = btree;
		// 打印
//		System.out.println("哈夫曼数前序遍历：");
//		tree.preOrder(tree.root());
	}
	
	/**
	 * 编解码表
	 */
	private void createMap() {
		encodeMap = new HashMap<>();
		decodeMap = new HashMap<>();
		// 获取哈夫曼树所有节点的路径信息
		Map<String, Node<HuffmanNode>> map = new HashMap<>();
		tree.scanNodePath(map, tree.root(), null);
		// 记录有效编码
		map.forEach((path, node) -> {
			if (node.getData().c != null) {
				encodeMap.put(node.getData().c, path);
				decodeMap.put(path, node.getData().c);
			}
		});
		System.out.println("哈夫曼编码表: " + encodeMap);
	}
	
	/**
	 * 统计文本中字符出现的频率
	 * @return
	 */
	private PriorityQueue<Node<HuffmanNode>> statisChar() {
		Map<Character, Integer> f = new HashMap<>();
		// 统计字符出现频率
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			Integer n = f.get(ch);
			if (n == null) {
				f.put(ch, 1);
			}
			else {
				f.put(ch, n+1);
			}
		}
		PriorityQueue<Node<HuffmanNode>> queue = new PriorityQueue<>(comparator);
		f.forEach((k, v) -> {
			HuffmanNode node = new HuffmanNode(k, v);
			queue.add(new Node<HuffmanNode>(node));
		});
		return queue;
	}
	
	/**
	 * 比较器，从小到大
	 */
	private static Comparator<Node<HuffmanNode>> comparator = new Comparator<Node<HuffmanNode>>() {
		@Override
		public int compare(Node<HuffmanNode> o1, Node<HuffmanNode> o2) {
			return o1.getData().f - o2.getData().f;
		}
	};
	
	/**
	 * 哈夫曼节点
	 */
	private static class HuffmanNode implements Comparable<HuffmanNode> {
		
		private Character c;
		
		private int f;
		
		public HuffmanNode(Character c, int f) {
			this.c = c;
			this.f = f;
		}

		@Override
		public int compareTo(HuffmanNode o) {
			return f - o.f;
		}

		@Override
		public String toString() {
			return "HuffmanNode [c=" + c + ", f=" + f + "]";
		}
		
	}

}
