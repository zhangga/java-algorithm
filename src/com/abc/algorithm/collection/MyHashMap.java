package com.abc.algorithm.collection;

import java.util.Arrays;
import java.util.Objects;

/**
 * 仅使用数组来实现一个HashMap，达到可以在O(1)时间复杂度内进行插入，查找。假设该集合容量的上限为M。
 * 
 * @author U-Demon
 * @date 2019年11月7日 上午10:45:37
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {
	
	/** 容器 */
	private Node<K, V>[] table;
	
	/** K的hash值对应table的下标 */
	private int[] first;
	
	/** table下标对应的next的下标，类似链表的效果 */
	private int[] next;
	
	/** 当前长度 */
	private int count;
	
	/** 容量 */
	private int capacity;
	
	/** 容量上限，2的倍数 */
	private static final int MAXIMUM_CAPACITY = 1 << 30;
	
	@SuppressWarnings("unchecked")
	public MyHashMap(int capacity) {
		if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
		if (capacity > MAXIMUM_CAPACITY)
			capacity = MAXIMUM_CAPACITY;
		
		this.capacity = tableSizeFor(capacity);
		this.count = 0;
		this.table = new Node[this.capacity];
		this.first = new int[this.capacity];
		Arrays.fill(this.first, -1);
		this.next = new int[this.capacity];
		Arrays.fill(this.next, -1);
	}
	
	public V put(K k, V v) {
		if (this.count >= this.capacity) {
			throw new IndexOutOfBoundsException("the map capacity is full");
		}
		
		int hash = hash(k) & (this.capacity - 1);
		int i = this.first[hash];
		while (i != -1) {
			Node<K, V> node = table[i];
			K key = null;
			if (node.hash == hash && ((key = node.key) == k) || (key != null && key.equals(k))) {
				return node.setValue(v);
			}
			i = this.next[i];
		}
		
		i = this.count++;
		this.table[i] = new Node<K, V>(hash, k, v);
		this.next[i] = this.first[hash];
		this.first[hash] = i;
		return v;
	}
	
	public V get(Object k) {
		int hash = hash(k) & (this.capacity - 1);
		int i = this.first[hash];
		while (i != -1) {
			Node<K, V> node = table[i];
			K key = null;
			if (node.hash == hash && ((key = node.key) == k) || (key != null && key.equals(k))) {
				return node.value;
			}
			i = this.next[i];
		}
		return null;
	}
	
	public int size() {
		return this.count;
	}
	
	private static final int hash(Object key) {
		int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	/**
	 * 比cap大的第一个2次方数
	 * @param cap
	 * @return
	 */
	private final int tableSizeFor(int cap) {
		int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}
	
	static class Node<K, V> {
		final int hash;
        final K key;
        V value;
        
        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
        
        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }
        
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        
        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Node) {
            	Node<?,?> e = (Node<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
	}

}
