package com.abc.algorithm.graph;

/**
 * 顶点
 *
 * @author U-Demon
 */
public class Vertex<E> {

	/** 存放的数据 */
	private E data;
	
	/** 是否访问过，用于搜索 */
	private boolean visited;
	
	public Vertex() {
		
	}
	
	public Vertex(E data) {
		this.data = data;
		this.visited = false;
	}
	
	public E getData() {
		return this.data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "Vertex [data=" + data + "]";
	}
	
}
