package com.abc.algorithm.recursive;

/**
 * 乘方，递归求解
 *
 * @author U-Demon
 */
public class Power {
	
	public static long doPower(long x, long y) {
		if (y == 1) {
			return x;
		}
		long p = y / 2;
		long u = y % 2;
		// 可以整除
		if (u == 0) {
			return doPower(x * x, p);
		}
		// 不可以整除的情况下，再乘一个x
		else {
			return doPower(x * x, p) * x;
		}
	}
	
	public static void start() {
		int x = 3;
		int y = 18;
		long n = doPower(x, y);
		System.out.println("计算乘方, " + x + "^" + y + "=" + n);
	}

}
