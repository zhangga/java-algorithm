package com.abc.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import com.abc.algorithm.collection.Stack;

/**
 * 图
 *
 * @author U-Demon
 */
public class Graph<E> {
	
	/** 默认初始顶点数 */
	private static final int INIT_VERTS = 16;
	
	/** 顶点列表 */
	private Vertex<E> vertexs[];
	
	/** 边 */
	private int adjMat[][];
	
	/** 顶点数 */
	private int nVerts;
	
	public Graph() {
		new Graph<E>(INIT_VERTS);
	}
	
	@SuppressWarnings("unchecked")
	public Graph(int n) {
		this.vertexs = new Vertex[n];
		adjMat = new int[n][n];
		nVerts = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adjMat[i][j] = 0;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addVertex(E data) {
		if (nVerts >= vertexs.length) {
			Vertex<E>[] temp = new Vertex[nVerts<<1];
			System.arraycopy(vertexs, 0, temp, 0, nVerts);
			vertexs = temp;
		}
		vertexs[nVerts++] = new Vertex<E>(data);
	}
	
	/**
	 * 无向图
	 * @param start
	 * @param end
	 */
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	/**
	 * 有向图
	 * @param start
	 * @param end
	 */
	public void addEdgeDir(int start, int end) {
		adjMat[start][end] = 1;
	}
	
	/**
	 * 带权图
	 * @param start
	 * @param end
	 * @param weight
	 */
	public void addEdgeWeight(int start, int end, int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	public void addEdgeDirW(int start, int end, int weight) {
		adjMat[start][end] = weight;
	}
	
	/**
	 * 深度优先搜索
	 */
	public void dfs() {
		Stack stack = new Stack(nVerts);
		vertexs[0].setVisited(true);
		displayVertex(0);
		stack.push(0);
		
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());
			if (v == -1) {
				stack.pop();
			}
			else {
				vertexs[v].setVisited(true);
				displayVertex(v);
				stack.push(v);
			}
		}
		
		for (int j = 0; j < nVerts; j++) {
			vertexs[j].setVisited(false);
		}
	}
	
	/**
	 * 广度优先搜索
	 */
	public void bfs() {
		LinkedList<Integer> queue = new LinkedList<>();
		vertexs[0].setVisited(true);
		displayVertex(0);
		queue.addLast(0);
		
		while (!queue.isEmpty()) {
			int top = queue.removeFirst();
			int v;
			while ((v = getAdjUnvisitedVertex(top)) != -1) {
				vertexs[v].setVisited(true);
				displayVertex(v);
				queue.addLast(v);
			}
		}
		
		for (int j = 0; j < nVerts; j++) {
			vertexs[j].setVisited(false);
		}
	}
	
	/**
	 * 最小生成树，使用DFS
	 */
	public void mst() {
		Stack stack = new Stack(nVerts);
		vertexs[0].setVisited(true);
		stack.push(0);
		
		while (!stack.isEmpty()) {
			int p = stack.peek();
			int v = getAdjUnvisitedVertex(p);
			if (v == -1) {
				stack.pop();
			}
			else {
				vertexs[v].setVisited(true);
				dispalyEdge(p, v);
				stack.push(v);
			}
		}
		
		for (int j = 0; j < nVerts; j++) {
			vertexs[j].setVisited(false);
		}
	}
	
	/**
	 * 获取一个点未访问的邻接点
	 * @param v
	 * @return
	 */
	private int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v][j] == 1 && vertexs[j].isVisited() == false) {
				return j;
			}
		}
		return -1;
	}
	
	/**
	 * 有向图的拓扑排序
	 * 必须是无环的有向图才有拓扑排序，所以也可以通过比较拓扑图的节点树和图的节点数来判断是否有环
	 */
	public void topo() {
		Stack topo = new Stack(nVerts);
		// clone一份，会修改数据
		int[][] mat = adjMat.clone();
		int v;
		while ((v = getNoPostVertex(mat)) != -1) {
			topo.push(vertexs[v]);
		}
		System.out.println("有向图的拓扑排序：" + topo.toString());
	}
	
	/**
	 * 获取没有后继的顶点
	 * @return
	 */
	private int getNoPostVertex(int[][] mat) {
		for (int i = 0; i < nVerts; i++) {
			boolean post = false;
			for (int j = 0; j < nVerts; j++) {
				if (/*i != j && */adjMat[i][j] == 1) {
					post = true;
					break;
				}
			}
			// 没有后继的节点
			if (!post) {
				// 把该节点关联的边删掉
				for (int v = 0; v < nVerts; v++) {
					if (v != i) {
						mat[v][i] = 0;
					}
				}
				// 修改节点自己，防止下次重复找到该节点
				mat[i][i] = 1;
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * warshall算法，有向图的连通性
	 * @return
	 */
	public int[][] warshall() {
		int[][] mat = adjMat.clone();
		for (int i = 0; i < nVerts; i++) {
			for (int j = 0; j < nVerts; j++) {
				// 存在i->j的连通
				int v = mat[i][j];
				if (v == 0) {
					continue;
				}
				// 找z->i的连通
				for (int z = 0; z < nVerts; z++) {
					// 则存在z->j的连通
					if (mat[z][i] == 1) {
						mat[z][j] = 1;
					}
				}
			}
		}
		return mat;
	}
	
	/**
	 * Floyd算法，带权图的最短路径
	 * @return
	 */
	public int[][] floyd() {
		int[][] mat = adjMat.clone();
		for (int i = 0; i < nVerts; i++) {
			for (int j = 0; j < nVerts; j++) {
				// 存在i->j的连通
				int v1 = mat[i][j];
				if (v1 == 0) {
					continue;
				}
				// 找z->i的连通
				for (int z = 0; z < nVerts; z++) {
					// 则存在z->j的连通
					int v2 = mat[z][i];
					if (v2 != 0) {
						int nv = v1 + v2;
						// 未连通
						if (mat[z][j] == 0) {							
							mat[z][j] = nv;
						}
						// 更短路径
						else if (mat[z][j] > nv) {
							mat[z][j] = nv;
						}
					}
				}
			}
		}
		return mat;
	}
	
	/**
	 * 带权图最小生成树
	 */
	public List<Edge> mstw() {
		// tree
		List<Edge> tree = new LinkedList<>();
		// 已访问的节点
		Set<Integer> visited = new HashSet<>();
		int last = 0;
		visited.add(0);
		// 优先级队列
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(nVerts);
		while (visited.size() < nVerts) {
			// 加入新节点的所有邻接点
			addLastConn(last, queue, visited);
			// 最小权重的边
			Edge min;
			while ((min = queue.poll()) != null) {
				// 未访问过
				if (!visited.contains(min.end)) {
					tree.add(min);
					
					last = min.end;
					visited.add(last);
					break;
				}
			}
		}
		// 返回最小生成树
		return tree;
	}
	
	private void addLastConn(int index, PriorityQueue<Edge> queue, Set<Integer> visited) {
		// 遍历该节点的所有邻接点
		for (int i = 0; i < nVerts; i++) {
			// 已经访问过的忽略
			if (i == index || visited.contains(i)) {
				continue;
			}
			int w = adjMat[index][i];
			if (w != 0) {
				Edge edge = new Edge(index, i, w);
				queue.add(edge);
			}
		}
	}
	
	/**
	 * 迪杰斯特拉算法
	 * @param start 起点（顶点索引）
	 * @param end 终点
	 */
	public Path dijkstra(int start, int end) {
		// 优先级队列
		PriorityQueue<Path> queue = new PriorityQueue<Path>(nVerts);
		// 已经找到最短路径的终点
		Set<Integer> visited = new HashSet<>();
		// 从起点开始
		Path path = new Path(0, start);
		// 直到到达终点
		while ((path = findPath(path, queue, visited)).end() != end);
		return path;
	}
	
	private Path findPath(Path path, PriorityQueue<Path> queue, Set<Integer> visited) {
		// 已经找到了最短路径的忽略
		if (visited.contains(path.end())) {
			return queue.poll();
		}
		int start = path.end();
		visited.add(start);
		// 找到点的邻接点
		for (int i = 0; i < nVerts; i++) {
			int d = adjMat[start][i];
			if (start != i && d > 0) {
				// 将邻接点的新路径加入优先级队列
				Path pn = new Path(path, i, d);
				queue.add(pn);
			}
		}
		return queue.poll();
	}
	
	private void displayVertex(int index) {
		System.out.print(vertexs[index].toString() + ", ");
	}
	
	private void dispalyEdge(int s, int e) {
		System.out.print(vertexs[s].toString() + vertexs[e].toString() + ", ");
	}
	
}
