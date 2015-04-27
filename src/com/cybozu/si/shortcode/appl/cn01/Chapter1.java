package com.cybozu.si.shortcode.appl.cn01;

//Chapter 1. 配列と文字列
// ある文字列が、すべてユニークであるかどうかを判定するアルゴリズムを実装
// また、それを実装するのに、新たなデータ構造が使えない場合どうすめばよいですか?
//
// (1) Implement an alogrithm to determine if a string has all unique characters.
// (2) What if you cannnot use addtional data structures?
//
// Alphabet a to z version (2014/08/11)

public class Chapter1 {

	public boolean dupCheck(String s) {

		// 半角英文字であることを前提とすると、53文字以上は無条件重複

		if (s.length() > 53) {
			return true;
		}

		boolean[] checkInt = new boolean[255];

		for(int i = 0; i < s.length(); i++) {
			int c = ((int)s.charAt(i));

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
