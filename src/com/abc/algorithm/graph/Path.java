package com.abc.algorithm.graph;

import java.util.LinkedList;

/**
 * 路径
 *
 * @author U-Demon
 */
public class Path implements Comparable<Path> {

	/** 距离 */
	public int d = 0;
	
	/** 路径 */
	public LinkedList<Integer> paths = new LinkedList<>();
	
	public Path() {
	}
	
	public Path(int d, int s) {
		this.d = d;
		this.paths.add(s);
	}
	
	public Path(Path path, int s, int d) {
		this.d = path.d + d;
		this.paths.addAll(path.paths);
		this.paths.add(s);
	}
	
	public int end() {
		return paths.getLast();
	}
	
	@Override
	public int compareTo(Path o) {
		return this.d - o.d;
	}

	@Override
	public String toString() {
		return "Path [d=" + d + ", paths=" + paths + "]";
	}
	
}
