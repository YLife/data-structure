package com.yl.datastructure;

import com.yl.common.ArrayException;
import com.yl.common.ExceptionUtil;

/**
 * 初始化一个数组并实现其增删改查
 * note：假设数组中无重复元素
 *       index：第几个数
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/15 20:19
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/15      yanglun            v1.0.0              修改原因
 */
public class ArrayStudy {

    private int[] intArray;
    private int realLength;// 实际长度
    private int limitLength;// 最大长度

    public ArrayStudy(int limitLength) {
        this.limitLength = limitLength;
        intArray = new int[limitLength];
    }

    // 遍历数组并展示
    public void display() {
        for (int i = 0; i < realLength; i++) {
            System.out.println("intArray[" + i + "] = " + intArray[i]);
        }
    }

    // 获取数组中执行索引位置的值
    public int get(int index) throws ArrayException {
        if (index < 1 || index > realLength) {
            ExceptionUtil.throwArrayException("访问下标越界！");
        }
        System.out.println("intArray[" + (index - 1) + "] = " + intArray[index - 1]);
        return intArray[index - 1];
    }

    // 查找指定值的索引，未查询到返回-1
    public int find(int value) throws ArrayException {
        int i;
        for (i = 0; i < realLength; i++) {
            if (value == intArray[i]) {
                break;
            }
        }
        if (i == realLength) {
            ExceptionUtil.throwArrayException("元素在数组中不存在！");
        }
        System.out.println(value + "在数组中的索引位置为：" + i);
        return i;
    }

    // 向数组末尾添加一个元素，实际添加时，可做数组扩容
    public boolean add(int value) throws ArrayException {
        if (realLength == limitLength) {
            ExceptionUtil.throwArrayException("数组存储空间已满，如需添加元素，请扩容！");
        }
        intArray[realLength] = value;
        realLength++;
        return true;
    }

    // 向数组指定位置插入一个元素，实际插入时，可做数组扩容
    public boolean insert(int index, int value) throws ArrayException {
        // 判断数组是否已满
        if (realLength == limitLength) {
            ExceptionUtil.throwArrayException("数组存储空间已满，如需添加元素，请扩容！");
        }
        if (index > limitLength || index < 1) {
            ExceptionUtil.throwArrayException("数组访问下标越界！");
        } else if (index >= realLength) {
            // 不做处理
        } else {
            // 先将插入位置后的元素后移一位
            for (int i = realLength; i >= index; i--) {
                intArray[i] = intArray[i - 1];
            }
        }
        intArray[index - 1] = value;
        realLength++;
        return true;
    }

    // 更新指定位置的数组元素
    public boolean update(int index, int newValue) throws ArrayException {
        if (index < 1 || index > realLength) {
            ExceptionUtil.throwArrayException("数组访问下标越界！");
        }
        intArray[index - 1] = newValue;
        return true;
    }

    // 删除指定位置的数组元素，实际删除应做数组缩容
    public boolean delete(int index) throws ArrayException {
        if (index < 1 || index > realLength) {
            ExceptionUtil.throwArrayException("数组访问下标越界！");
        }
        if (index == realLength) {
            // 不做处理
        } else {
            for (int i = index; i < realLength; i++) {
                intArray[i - 1] = intArray[i];
            }
        }
        realLength--;
        return true;
    }

    public static void main(String[] args) throws ArrayException {
        ArrayStudy array = new ArrayStudy(6);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.display();
        array.get(2);
        array.find(3);
        array.insert(2, 5);
        System.out.println("============");
        array.display();
        array.update(2, 6);
        System.out.println("============");
        array.display();
        array.delete(2);
        System.out.println("============");
        array.display();
    }
}
