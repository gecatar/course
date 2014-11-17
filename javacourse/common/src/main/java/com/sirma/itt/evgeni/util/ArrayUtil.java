package com.sirma.itt.evgeni.util;

/**
 * Execute functions for manipulating Arrays.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ArrayUtil {
	/**
	 * Find element whit minimal value.
	 * 
	 * @param array
	 *            object that will be manipulated.
	 * @return index of smallest element.
	 */
	public static int getMinElement(int[] array) {

		int minIndex = 0;
		int minValue;
		minValue = array[0];
		for (int i = 0; i < array.length; i++) {
			if (minValue > array[i]) {
				minValue = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	/**
	 * Calculate sum of all number from array.
	 * 
	 * @param array
	 *            object that will be manipulated.
	 * @return sum of all element from array
	 */
	public static int sum(int[] array) {

		int sum = 0;
		for (int value : array) {
			sum += value;
		}
		return sum;
	}

	/**
	 * Create String from all numbers in array.
	 * 
	 * @param array
	 *            object that will be manipulated.
	 * @return string with all element of array
	 */
	public static String print(int[] array) {

		StringBuilder stringBuilder = new StringBuilder();
		for (int value : array) {
			stringBuilder.append(Integer.toString(value)).append(" ");
		}
		return stringBuilder.toString();
	}

	/**
	 * Find index of median.
	 * 
	 * @param array
	 *            object that will be manipulated.
	 * @return index of Median.
	 */
	public static int getMedian(int[] array) {

		int mdnIndex;
		int left = 0;
		int right = (array.length - 1);
		int leftBuff = array[left];
		int rightBuff = array[right];
		while (left < right) {
			if (leftBuff < rightBuff) {
				left++;
				leftBuff += array[left];
			} else {
				right--;
				rightBuff += array[right];
			}
		}
		mdnIndex = left;
		return mdnIndex;
	}

	/**
	 * Apply quick sort algorithm.
	 * 
	 * @param array
	 * @param left
	 *            sorting will start from "left" element
	 * @param right
	 *            sorting will stop at element whit index = right
	 * @return sorted massive
	 */
	public static int[] quickSort(int[] array, int left, int right) {

		int indexLeft = left;
		int indexRight = right;
		int indexPivot = (left + right) / 2;
		int pivot = array[indexPivot];
		while (indexLeft <= indexRight) {
			if (array[indexLeft] < pivot) {
				indexLeft++;
			} else {
				if (array[indexRight] > pivot) {
					indexRight--;
				} else {
					int temp = array[indexRight];
					array[indexRight] = array[indexLeft];
					array[indexLeft] = temp;
					indexLeft++;
					indexRight--;
				}
			}
		}
		if (indexRight > left) {
			ArrayUtil.quickSort(array, left, indexRight);
		}
		if (indexLeft < right) {
			ArrayUtil.quickSort(array, indexLeft, right);
		}
		return array;
	}

	/**
	 * Reverse all element in array.
	 * 
	 * @param array
	 *            object that will be manipulated.
	 * @return reversed array
	 */
	public static int[] reverse(int[] array) {

		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int temp = array[right];
			array[right] = array[left];
			array[left] = temp;
			left++;
			right--;
		}
		return array;
	}

	/**
	 * Reverse all element in byte array.
	 * 
	 * @param array
	 *            object that will be reversed.
	 * @return reversed array.
	 */
	public static byte[] reverse(byte[] array) {

		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			byte temp = array[right];
			array[right] = array[left];
			array[left] = temp;
			left++;
			right--;
		}
		return array;
	}

}