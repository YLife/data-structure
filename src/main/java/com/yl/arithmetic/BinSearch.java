package com.yl.arithmetic;

/**
 * @description 二分查找
 *
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/28 23:49
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/28      yanglun            v1.0.0              修改原因
 */
public class BinSearch {

    public static int search(int array[], int target) {
        int start = 0;
        int end = array.length;
        int mid;
        while (start < end) {
            mid = (end - start) / 2 + start;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {1, 3, 6, 7, 9, 10, 20};
        int index = search(array, 20);
        System.out.println(index);
    }
}
