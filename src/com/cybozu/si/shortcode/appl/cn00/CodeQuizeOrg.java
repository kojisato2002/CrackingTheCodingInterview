package com.cybozu.si.shortcode.appl.cn00;

public class CodeQuizeOrg {

	public static final int distance2dimension(int ax, int ay, int bx, int by) {

		if(ax==bx) {
			if(ay==by) {
				return 0;
			} else {
				return Math.abs(ay - by);
			}
		} else {
			if(ay==by) {
				return Math.abs(ax - bx);
			} else {
				return calcPythagorean(ax, ay, bx, by);
			}
		}
	}

	private static int calcPythagorean(int ax, int ay, int bx, int by) {
		
		int x, y;
		
		if(ax > bx) {
			x = ax - bx;
		} else {
			x = bx - ax;
		}
		if(ay > by) {
			y = ay - by;
		} else {
			y = by - ay;
		}
		
		return x + y;
	}


}
