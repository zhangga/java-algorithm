package com.abc.algorithm.recursive;

/**
 * 汉诺塔问题
 *
 * @author U-Demon
 */
public class Towers {
	
	/** 盘子的数量 */
	private int nDisks = 0;
	
	/** 塔的顺序 */
	private String[] towers = new String[] {"A", "B", "C"};
	
	public Towers(int nDisks) {
		this.nDisks = nDisks;
	}
	
	public void doTowers() {
		doTowers(nDisks, towers[0], towers[1], towers[2]);
	}
	
	/**
	 * 将topN个盘子从from移动到to
	 * @param topN 要移动的盘子数
	 * @param from
	 * @param inter
	 * @param to
	 */
	private void doTowers(int topN, String from, String inter, String to) {
		if (topN == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		}
		// 将问题分解成
		else {
			// topN-1个盘子从from移动到inter
			doTowers(topN - 1, from, to, inter);
			// 再将剩余的盘子从from移动到to
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			// 把topN-1个盘子再从inter移动到to
			doTowers(topN - 1, inter, from, to);
		}
	}
	
	public static void start() {
		System.out.println("汉诺塔问题：");
		Towers towers = new Towers(3);
		towers.doTowers();
	}

}
