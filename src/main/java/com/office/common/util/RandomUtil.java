package com.office.common.util;

import java.util.Random;

/**
 * 
 * 随机内容生成工具类
 * 
 * @author Neo 2017-5-23
 *
 */
public class RandomUtil {

	/**
	 * 得到某个范围的随机数
	 * 
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return 随机数
	 */
	public static Integer generalSingleRandom(int min, int max) {
		Random random = new Random();
		// 生成一个在min和max之间的随机数
		int result = min + random.nextInt(max - min);
		return result;
	}

	/**
	 * 得到某个范围的随机数组
	 * 
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @param num
	 *            随机数的个数
	 * @return 随机数组
	 */
	public static int[] generalArrayleRandom(int min, int max, int num) {
		int[] result = new int[num];
		Random random = new Random();
		int r;
		for (int i = 0; i < num; i++) {
			// 生成一个在min和max之间的随机数
			r = min + random.nextInt(max - min);
			result[i] = r;
		}
		return result;
	}
}
