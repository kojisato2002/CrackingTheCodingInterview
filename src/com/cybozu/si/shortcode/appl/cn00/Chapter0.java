package com.cybozu.si.shortcode.appl.cn00;

import java.math.BigDecimal;

public class Chapter0 {
	private int time;
	private int minute;
	
	public BigDecimal longHandle;
	public BigDecimal shortHandle;
	public BigDecimal shortHandleAdd;
	
	public void setTimeMinute(int i, int j) {
		this.setTime(i);
		this.setMinute(j);
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	// P55 Approach 1:アナログ時計において、与えられた時間から長針と短針の角度を計算する
	public int clockAngle() {
		// 長針の計算は、360° / 60分 X 計算分数(minute)で計算される。(秒以下は無視)
		BigDecimal timeAngle = BigDecimal.valueOf(360 / 60);
		longHandle = timeAngle.multiply(BigDecimal.valueOf(minute));
		// 24時間表示を正規化
		if(time > 12) {time -= 12;}
		// 短針の計算は、まず、360° / 12時間 (30°) X 計算時間
		BigDecimal hourAngle = BigDecimal.valueOf(360 / 12);		
		shortHandle = hourAngle.multiply(BigDecimal.valueOf(time));
		// 次に分数の進みを計算する。60分で、30°進むので、1分あたりは、0.5°、これに分数をかける
		shortHandleAdd = BigDecimal.valueOf(minute).multiply(hourAngle.divide(BigDecimal.valueOf(60))); 
		// 計算された分数の進み角度を、初期短針確度に加算する
		shortHandle = shortHandle.add(shortHandleAdd);
		return 0;
	}
	// P55 Approach 2:循環配列最小値探索リニアサーチ(大小が逆転しているところを探索)
	public int circleArraySearchLinear(int[] al) {
		int intBefore = 0;
		int cntArray = 0;
		for (int i : al) {
			cntArray ++;
			if(intBefore < i) {
				intBefore = i;
			} else {
				break;
			}
		}
		return cntArray;
	}
	// 循環配列最小値探索バイナリサーチ(よくわからんで書いてしまった)
	public int circleArraySearchBinary(int[] al) {
		int intSearch = 0;									// 探索開始配列index
		int intCenter = al.length / 2;						// 初期二分引き(少数は切捨てに注意)
		
		if(al[intCenter - 1] > al[intCenter]) {				// 最初にそこが転換点の対処
			return ++intCenter;
		}
		
		for (;intCenter > 0;) {
			// 分割地点の設定、要素数を2で割った切り上げ値。int標準だと切り下げ
			int wp = ((intCenter - intSearch) / 2) + ((intCenter - intSearch) % 2);
//			int wp = (intCenter - intSearch) / 2;
//			int wp = Math.round((intCenter - intSearch) / 2.0f);
			
			if(al[intSearch] < al[intCenter]) 				// 探索開始要素と二分引き要素の大小が逆転していないか
			{												// 逆転している場合に、そちらの配列範囲に存在
				intSearch = intCenter;						// 逆転していない場合、二分引き箇所を開始地点に
				intCenter = intCenter + wp;					// 二分引きindexと、開始indexの差を次の二分引き値とする
			} else {
				intCenter = intCenter - wp;
			}
			if (intSearch == intCenter -1) {				// 二分引きする要素が無くなったときの判定
				if(al[intSearch] < al[intCenter]) 
				{
					intSearch += 2;
					
				} else {
					intSearch += 1;
				}
				break;
			}
		}
		return ++intSearch;
	}
	//　循環配列最小値探索バイナリサーチ(探索ポインターの計算にフォーカス)
	// 左隣との大小関係逆転を判定条件とする
	public int circleArraySearchBinary2(int[] al) {
		
		if (al.length < 2) {return 0;}						// 要素数1以下は0返却
		int loop_cnt = 0;									// 安全用カウンター

		int noe = al.length;								// 要素数(Number of Elements)
		int sp = 0;											// 開始点初期値
		int ep = (noe / 2) - (noe % 2);						// 終了点初期値(切捨て後配列0開始の調整)
		int low_cnt = ep - sp + 1;							// 前半部分の要素数
		int upp_cnt = noe - low_cnt;						// 後半部分の要素数

		for (;;) {
			int rst = ep - sp;								// 探索範囲の数
			if(al[sp] < al[ep]) {							// 要素の昇順が維持されているので、後半部分を探査させる
				sp = ep + 1;								// 開始点を直前の終了地点 + 1に
				ep = sp + upp_cnt - 1;						// 終了点は、新しい開始点 + 後半部分の要素数
			} else {										// 要素の昇順が維持されていない ので、前半部分を探索させる、開始点はそのまま。
				if(rst < 5) {								// 探索範囲の数が4以下であれば、直接判定させる。
					if(ep > 1) {
						if(al[ep - 1] > al[ep]) {
							return al[ep];
						}
					}
					if(sp < (noe -1)) {
						if(al[sp] > al[sp + 1]) {
							return al[sp + 1];
						}
					}
					
				}
				ep = sp + (low_cnt / 2) - (low_cnt % 2);	// 終了点を、開始点 + 残りの前半部分要素数 / 2(切捨て)
				upp_cnt = low_cnt - (rst + 1);
				low_cnt = rst + 1;							// 前半部分の要素数は終了点 - 開始点
			}
			
			if (ep < 0 || sp >= noe) {return 0;}
												
			if(al[sp] > al[ep]) {
				return al[ep];
			}

			if(loop_cnt++ > al.length) {return 0;}
		}
	}
}
