package com.cybozu.si.shortcode.test.cn00;


import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cybozu.si.shortcode.appl.cn00.Chapter0;

public class testChapter0 {

	private Chapter0 c0 = new Chapter0();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClockAngle() {

		c0.setTimeMinute(13, 59);
		assertEquals(0, c0.clockAngle());
		assertEquals(BigDecimal.valueOf(354), c0.longHandle);
		assertEquals(BigDecimal.valueOf(59.5), c0.shortHandle);

		c0.setTimeMinute(15, 00);
		assertEquals(0, c0.clockAngle());
		assertEquals(BigDecimal.valueOf(0), c0.longHandle);
		assertEquals(BigDecimal.valueOf(90.0), c0.shortHandle);
		assertEquals(BigDecimal.valueOf(180.0), c0.analogClockAngle(6, 0));

		c0.setTimeMinute(18, 15);
		assertEquals(0, c0.clockAngle());
		assertEquals(BigDecimal.valueOf(90), c0.longHandle);
		assertEquals(BigDecimal.valueOf(187.5), c0.shortHandle);
	}
	@Test
	public void testCircleArraySearch() {
		int al[] = {3,4,5,6,7,8,9,10,1,2};
		assertEquals(9, c0.circleArraySearchLinear(al));

		// 循環配列転換点テストコード(動的)
		int cntArray = 9999999;
		int shiftInt = 200001;
		int index = 1;
		int[] al2 = new int[cntArray];
		for (int i = shiftInt - 1; i < cntArray; i++) {
			al2[i] = index++;
		}
		for (int i = 0; i < shiftInt -1; i++) {
			al2[i] = index++;
		}
		long start = System.currentTimeMillis();
		int ans = c0.circleArraySearchLinear(al2);
		assertEquals(shiftInt, ans);
		long end = System.currentTimeMillis();
		System.out.print("ans:" + al2[ans - 1]);
		System.out.println(" 単純リニア探索処理時間 :" + (end - start) + " ミリ秒");
		/*
		start = System.currentTimeMillis();
		ans = c0.circleArraySearchBinary(al2);
		assertEquals(shiftInt, ans);
		end = System.currentTimeMillis();
		System.out.print("ans:" + al2[ans -1]);
		System.out.println(" 二分探索(1)処理時間 :" + (end - start) + " ミリ秒");

		int[] al3 = {1};
		ans = c0.circleArraySearchBinary2(al3);
		assertEquals(0, ans);
		int[] al4 = {1, 2};
		ans = c0.circleArraySearchBinary2(al4);
		assertEquals(0, ans);

		int[] al5 = {1, 2, 3, 4, 5, 6 ,7};
		ans = c0.circleArraySearchBinary2(al5);
		assertEquals(0, ans);


		int[] al6 = {8, 9, 3, 4, 5, 6, 7};
		ans = c0.circleArraySearchBinary2(al6);
		assertEquals(3, ans);
*/

		/*
		int[] al7 = {9, 10, 3, 4, 5, 6, 7, 8};
		ans = c0.circleArraySearchBinary2(al7);
		assertEquals(3, ans);

		int[] al8 = {31,32,33,34,35,36,37,38,39,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		ans = c0.circleArraySearchBinary2(al8);
		assertEquals(10, ans);

		start = System.currentTimeMillis();
		ans = c0.circleArraySearchBinary2(al2);
		assertEquals(1, ans);
		end = System.currentTimeMillis();
		System.out.print("ans:" + ans);
		System.out.println(" 二分探索(2)処理時間 :" + (end - start) + " ミリ秒");
*/
	}

}
