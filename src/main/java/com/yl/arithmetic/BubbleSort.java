package com.yl.arithmetic;

/**
 * @description 冒泡排序
 *
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/28 23:49
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/28      yanglun            v1.0.0              修改原因
 */
public class BubbleSort {

    // 升序排列
    public static void sortByAsc(int array[]) {
        for (int i = 0; i < array.length; i++) {
            // 有序标识，flag为true，标识数据已有序，不用再进行排列
            boolean flag = true;
            for (int j = 0; j < array.length - i -1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void display(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = {1, 7, 9, 10, 3, 6, 20};
        System.out.print("排序前：");
        display(array);
        sortByAsc(array);
        System.out.print("排序后：");
        display(array);
    }
}
