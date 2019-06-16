package com.yl.datastructure;

import com.yl.common.ArrayException;
import com.yl.common.ExceptionUtil;

import java.util.Arrays;

/**
 * 初始化一个栈并实现压栈、谈栈
 * note：空间不足时，考虑扩容
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/16 0:09
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/16      yanglun            v1.0.0              修改原因
 */
public class StackStudy {

    private Object[] elementData;
    private int top;// 栈顶指针
    private int size;

    // 构造一个默认容量为2的栈，容量小，便于测试扩容场景
    public StackStudy() {
        elementData = new Object[2];
        top = -1;
        size = 2;
    }

    // 构造一个容量为initialCapacity的栈
    public StackStudy(int initialCapacity) throws ArrayException {
        if (initialCapacity < 0) {
            ExceptionUtil.throwArrayException("栈初始容量不能小于0！");
        }
        elementData = new Object[initialCapacity];
        top = -1;
        size = initialCapacity;
    }

    // 压栈
    public void push(Object object) {
        isGrow(top + 1);
        elementData[++top] = object;
    }

    // 弹栈
    public Object pop() throws ArrayException {
        Object object = peek();
        elementData[top] = null;
        top--;
        return object;
    }

    // 获取栈顶元素
    public Object peek() throws ArrayException {
        if (isEmpty()) {
            ExceptionUtil.throwArrayException("空栈无法获取栈顶元素！");
        }
        System.out.println("栈顶元素为：" + elementData[top]);
        return elementData[top];
    }

    // 使用场景1：字符串反转
    public String reverseStr(String str) throws ArrayException {
        if (str == null || "".equals(str)) {
            return str;
        }
        char[] charArr = str.toCharArray();
        for (char cha : charArr) {
            push(cha);
        }
        StringBuilder sb = new StringBuilder();
        while (!isEmpty()) {
            sb.append(pop());
        }
        return sb.toString();
    }

    // 使用场景2：判断括号是否匹配
    public boolean isMatch(String str) throws ArrayException {
        if (str == null || "".equals(str)) {
            System.out.println("字符串为空，默认匹配成功！！！");
            return true;
        }
        char[] charArr = str.toCharArray();
        for (char cha : charArr) {
            switch (cha) {
                case '<':
                    push(cha);
                    break;
                case '(':
                    push(cha);
                    break;
                case '[':
                    push(cha);
                    break;
                case '{':
                    push(cha);
                    break;
                case '>':
                    isPop(cha);
                    break;
                case ')':
                    isPop(cha);
                    break;
                case ']':
                    isPop(cha);
                    break;
                case '}':
                    isPop(cha);
                    break;
                default:
                    break;
            }
        }
        if (isEmpty()) {
            System.out.println("括号匹配成功！！！");
            return true;
        }
        System.out.println("括号匹配失败！！！");
        return false;
    }

    // 是否需要弹栈
    private void isPop(char cha) throws ArrayException {
        if (!isEmpty()) {
            Character character = (Character) peek();
            if (cha == '>' && '<' == character
                    || cha == ')' && '(' == character
                    || cha == ']' && '[' == character
                    || cha == '}' && '{' == character) {
                pop();
            } else {
                // 暂时处理为压栈，其实可以直接抛出异常不匹配
                push(cha);
            }
        }
    }

    // 判断栈是否为空
    private boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    // 判断是否需要扩容
    private boolean isGrow(int minCapacity) {
        int oldCapacity = size;
        // 如果总容量小于当前所需最小容量，则需要进行扩容
        if (oldCapacity <= minCapacity) {
            int newCapacity = 0;
            // 每次扩容为原来的2倍
            if (minCapacity > Integer.MAX_VALUE) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = size << 1;// 左移以为相当于*2
            }
            size = newCapacity;
            elementData = Arrays.copyOf(elementData, size);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ArrayException {
        StackStudy stack = new StackStudy();
        System.out.println("开始压栈=====");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.peek();
        System.out.println("开始弹栈======");
        stack.pop();
        stack.pop();
        stack.pop();
        // 测试字符串反转
        stack.reverseStr("You are beautiful !");
        // 测试括号匹配
        stack.isMatch("<{}]()>");
    }

}
