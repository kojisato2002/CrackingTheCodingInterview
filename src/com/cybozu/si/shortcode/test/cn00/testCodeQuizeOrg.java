package com.cybozu.si.shortcode.test.cn00;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cybozu.si.shortcode.appl.cn00.CodeQuizeOrg;

public class testCodeQuizeOrg {

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


	// 二次元座標の2点座標情報から距離を計算するテスト
	@Test
	public void testBasicCondition() {
		// 同一座標のケース
		assertEquals(0, CodeQuizeOrg.distance2dimension(10,10,10,10)); // (ax, ay)     == (bx , by)
		// x座標は同一で、by座標のみ異なる
		assertEquals(5, CodeQuizeOrg.distance2dimension(10,10,10,5));  // (ax, ay)     <> (bx , by -5)
		// x座標は同一で、ay座標のみ異なる
		assertEquals(6, CodeQuizeOrg.distance2dimension(10,4,10,10));  // (ax, ay - 4) <> (bx, by)
		// y座標は同一で、bx座標のみ異なる
		assertEquals(7, CodeQuizeOrg.distance2dimension(10,10,3,10));  // (ax, ay)     <> (bx - 3, by)
		// y座標は同一で、ax座標のみ異なる
		assertEquals(8, CodeQuizeOrg.distance2dimension(2,10,10,10));  // (ax - 2, ay) <> (bx, by)
	}
	@Test
	public void testPythagorean() {
		// 共に第1象限にある
		assertEquals(14, CodeQuizeOrg.distance2dimension(10,10,20,20));
		// 第1象限と第2象限(xが負)にある
		assertEquals(31, CodeQuizeOrg.distance2dimension(-10,10,20,20));
		// 第1象限と第3象限(ともに負)にある
		assertEquals(42, CodeQuizeOrg.distance2dimension(-10,-10,20,20));
		// 第1象限と第4象限(yが負)にある
		assertEquals(31, CodeQuizeOrg.distance2dimension(10,-10,20,20));
	}

}
