package com.yl.datastructure;

import com.yl.common.ArrayException;
import com.yl.common.ExceptionUtil;

/**
 * 初始化一个循环队列并实现进队、出队
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/16 15:13
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/16      yanglun            v1.0.0              修改原因
 */
public class QueueStudy {

    private Object[] queue;
    private int front;
    private int rear;
    private int maxSize;// 最大容量
    private int realSize;// 实际使用容量

    // 构造一个默认容量为3的队列，容量小，便于测试循环队列场景
    public QueueStudy() {
        queue = new Object[3];
        front = 0;
        rear = -1;
        maxSize = 3;
        realSize = 0;
    }

    // 向队列中插入一个元素
    public void insert(Object object) throws ArrayException {
        if (isFull()) {
            ExceptionUtil.throwArrayException("队列已满，如需存储，请扩容！！！");
        }
        // 如果队尾指向最大存储地址，循环回来指向最低地址
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = object;
        realSize++;
        System.out.println("队尾指针为：" + rear);
    }

    // 从队列中移除一个元素
    public Object remove() throws ArrayException {
        if (isEmpty()) {
            ExceptionUtil.throwArrayException("队列为空，无法进行移除操作！！！");
        }
        Object object = queue[front];
        queue[front] = null;
        front++;
        if (front == maxSize) {
            front = 0;
        }
        realSize--;
        System.out.println("队头指针为：" + front);
        return object;
    }

    // 查看队头元素
    public Object peek() {
        System.out.println("队头元素为：" + queue[front]);
        return queue[front];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        if (realSize == 0) {
            return true;
        }
        return false;
    }

    // 判断队列是否已满
    public boolean isFull() {
        if (realSize == maxSize) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ArrayException {
        QueueStudy queue = new QueueStudy();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.peek();
        queue.remove();
        queue.insert(4);
        queue.peek();
    }
}
