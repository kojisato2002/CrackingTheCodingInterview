package com.cybozu.si.shortcode.appl.cn01;

//Chapter 1. 配列と文字列
// Alphabet a to z version (2014/08/11)

public class Chapter1 {
	// 1.1
	StringBuffer sb = new StringBuffer();

	public boolean dupCheck(String s) {

		if (s.length() > 26) {
			return true;
		}

		boolean[] checkInt = new boolean[26];

		for(int i = 0; i < s.length(); i++) {
			int c = ((int)s.charAt(i));
			int a_code = ('a');
			c = c - a_code;

			if(checkInt[c]) {
				return true;
			} else {
				checkInt[c] = true;
			}

		}
		return false;
	}

	public boolean sampleFalse() {
		return false;
	}

}
