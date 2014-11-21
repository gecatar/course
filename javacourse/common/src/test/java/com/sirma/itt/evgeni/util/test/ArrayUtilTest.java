package com.sirma.itt.evgeni.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.util.ArrayUtil;

public class ArrayUtilTest {

	/**
	 * Check correct finding on index of smallest element.
	 */
	@Test
	public void findMinIndexFirst() {
		int[] array = { 1, 12, 2, 100, 3, 4, 5, 0 };
		int expectedIndex = 7;
		int actualIndex = ArrayUtil.getMinElement(array);
		
		assertEquals(expectedIndex,actualIndex);
	}
	
	/**
	 * Check correct finding on index of smallest element.
	 */
	@Test
	public void findMinIndexSecond() {
		int[] array = { 1, 12, 2, 0, 3, 4, 5, 100 };
		int expectedIndex = 3;
		int actualIndex = ArrayUtil.getMinElement(array);
		
		assertEquals(expectedIndex,actualIndex);
	}
	
	/**
	 * Check correct finding on sum of the array.
	 */
	@Test
	public void findSumFirst() {
		int[] array = { 1, 2, 3, 3, 4, 5, 0 };
		int expectedSum = 18;
		int actualSum = ArrayUtil.sum(array);
		
		assertEquals(expectedSum,actualSum);
	}
	
	/**
	 * Check correct finding on sum of the array.
	 */
	@Test
	public void findSumSecond() {
		int[] array = { 1, 2, 3, 3, 4, 5, 6 };
		int expectedSum = 24;
		int actualSum = ArrayUtil.sum(array);
		
		assertEquals(expectedSum,actualSum);
	}
	
	/**
	 * Check correct string representation on the array.
	 */
	@Test
	public void printFirstTest() {
		int[] array = { 1, 2, 3, 3, 4, 5, 67, 68 };
		String expectedString = "1 2 3 3 4 5 67 68 ";
		String actualString = ArrayUtil.print(array);
		assertEquals(expectedString, actualString);
	}
	
	/**
	 * Check correct string representation on the array.
	 */
	@Test
	public void printSecondTest() {
		int[] array = { 112, 2, 38, 39, 4, 5, 67, 68 };
		String expectedString = "112 2 38 39 4 5 67 68 ";
		String actualString = ArrayUtil.print(array);
		assertEquals(expectedString, actualString);
	}
	
	/**
	 * Call ArrayUtil and check index of median.
	 */
	@Test
	public void findMedianFirst() {
		
		int[] array = { 1, 12, 2, 100, 3, 4, 5, 1 };
		int expectedIndex = 3;
		int actualIndex = ArrayUtil.getMedian(array);
		
		assertEquals(expectedIndex,actualIndex);
	}
	
	/**
	 * Call ArrayUtil and check index of median.
	 */
	@Test
	public void findMedianSecond() {
		
		int[] array = { 1, 12, 2, 1, 3, 4, 5, 1 };
		int expectedIndex = 2;
		int actualIndex = ArrayUtil.getMedian(array);
		
		assertEquals(expectedIndex,actualIndex);
	}
	
	/**
	 * Pass one unsorted array and check order.
	 */
	@Test
	public void testSortingFirst() {
		
		int[] array         = { 7, 4, 5, 1, 2, 6 };
		int[] expectedArray = { 1, 2, 4, 5, 6, 7 };
		int[] actualArray;

		actualArray = ArrayUtil.quickSort(array, 0, array.length-1);
		
		assertArrayEquals(expectedArray, actualArray);
	}
	
	/**
	 * Pass one unsorted array and check order.
	 */
	@Test
	public void testSortingSecond() {
		
		int[] array         = { 12, 6, 5, 1, 2, 4, 7, 78, 100 };
		int[] expectedArray = { 1, 2, 4, 5, 6, 7, 12, 78, 100 };
		int[] actualArray;

		actualArray = ArrayUtil.quickSort(array, 0, array.length-1);
		
		assertArrayEquals(expectedArray, actualArray);
	}
	
	/**
	 * Pass Array and check the order.
	 */
	@Test
	public void reverseArrayFirstTest() {

		int[] array		    = { 7, 4, 5, 1, 2, 6 };
		int[] expectedArray = { 6, 2, 1, 5, 4, 7 };
		int[] actualArray;

		actualArray = ArrayUtil.reverse(array);

		assertArrayEquals(expectedArray, actualArray);
	}
	
	/**
	 * Pass Array and check the order.
	 */
	@Test
	public void reverseArraySecondTest() {

		int[] array		    = { 8, 4, 9, 1, 3, 6 };
		int[] expectedArray = { 6, 3, 1, 9, 4, 8 };
		int[] actualArray;

		actualArray = ArrayUtil.reverse(array);

		assertArrayEquals(expectedArray, actualArray);
	}


}
