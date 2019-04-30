package com.abc.algorithm.graph;

/**
 * 边
 *
 * @author U-Demon
 */
public class Edge implements Comparable<Edge> {
	
	public int start;
	
	public int end;
	
	public int weight;

	public Edge() {
		
	}
	
	public Edge(int s, int e, int w) {
		this.start = s;
		this.end = e;
		this.weight = w;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}

}
