package com.cybozu.si.shortcode.test.cn01;

//Alphabet a to z version (2014/08/11)

import static org.junit.Assert.*;

import org.junit.Test;

import com.cybozu.si.shortcode.appl.cn01.Chapter1;


public class testChapter1 {
	String strOver26 = "abcdefghijklmnopqrstuvwxyza";
	String strDuplicate = "abca";
	String strNoDuplicate = "abcdefghijklmn";

	private Chapter1 c1 = new Chapter1();
	@Test
	public void testFirst() {
		assertEquals(c1.sampleFalse(), false);
	}
	@Test
	public void testOver26() {
		assertEquals(c1.dupCheck(strOver26), true);
	}
	@Test
	public void testDuplicate() {
		assertEquals(c1.dupCheck(strDuplicate), true);
	}
	@Test
	public void testNoDuplicate() {
		assertEquals(c1.dupCheck(strNoDuplicate), false);
	}

}
