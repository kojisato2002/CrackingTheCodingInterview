package com.cybozu.si.shortcode.appl.cn00;

public class CodeQuizeOrg {


	// 二次元座標の2点座標情報から距離を計算する

	public static final int distance2dimension(int ax, int ay, int bx, int by) {

		// x, y の一致
		if(ax==bx) {
			// y軸も一致
			if(ay==by) {
				// x, y 共に一致している場合の距離は0
				return 0;
			} else {
				// x軸のみ不一致なので、yの差を計算して返却
				return Math.abs(ay - by);
			}
		// x軸は不一致
		} else {
			// y軸は一致
			if(ay==by) {
				// y軸のみの一致なので、xの差を計算して返却
				return Math.abs(ax - bx);
			} else {
				// x, y 共に不一致なので、計算関数に移譲
				return calcPythagorean(ax, ay, bx, by);
			}
		}
	}

	private static int calcPythagorean(int ax, int ay, int bx, int by) {

		int x, y;
		// x軸の距離を計算
		if(ax > bx) {
			x = ax - bx;
		} else {
			x = bx - ax;
		}
		// y軸の距離を計算
		if(ay > by) {
			y = ay - by;
		} else {
			y = by - ay;
		}
		// Pythagorean Calculate
		return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

	}
}
