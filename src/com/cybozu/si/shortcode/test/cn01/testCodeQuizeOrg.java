package com.cybozu.si.shortcode.test.cn01;

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

	@Test
	public void testBasicCondition() {
		assertEquals(0, CodeQuizeOrg.distance2dimension(10,10,10,10)); // (ax, ay)     == (bx , by)
		assertEquals(5, CodeQuizeOrg.distance2dimension(10,10,10,5));  // (ax, ay)     <> (bx , by -5)
		assertEquals(6, CodeQuizeOrg.distance2dimension(10,4,10,10));  // (ax, ay - 4) <> (bx, by)
		assertEquals(7, CodeQuizeOrg.distance2dimension(10,10,3,10));  // (ax, ay)     <> (bx - 3, by)
		assertEquals(8, CodeQuizeOrg.distance2dimension(2,10,10,10));  // (ax - 2, ay) <> (bx, by)
	}
	@Test
	public void testPythagorean() {
		assertEquals(60, CodeQuizeOrg.distance2dimension(-10,-10,20,20));
	}

}
