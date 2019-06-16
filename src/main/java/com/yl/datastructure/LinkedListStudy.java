package com.yl.datastructure;

import com.yl.common.ArrayException;
import com.yl.common.ExceptionUtil;

/**
 * 初始化一个链表并实现插入、删除操作
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/16 23:45
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/16      yanglun            v1.0.0              修改原因
 */
public class LinkedListStudy {

    private int size;// 节点数目
    private Node head;// 头结点

    private class Node {
        private Object data;// 节点值
        private Node next;// 指向的下一个节点

        public Node(Object data) {
            this.data = data;
        }
    }

    // 构造一个空链表
    public LinkedListStudy() {
        this.size = 0;
        this.head = null;
    }

    // 在某个指定元素后插入目标元素
    public void insert(Object beforeObject, Object targetObject) throws ArrayException {
        if (targetObject == null) {
            ExceptionUtil.throwArrayException("插入的目标对象不能为空！！！");
        }
        Node node = new Node(targetObject);
        Node beforeNode = null;
        if (beforeObject != null) {
            beforeNode = findObject(beforeObject);
        }
        Node afterNode = head;// 后继节点，默认为当前head
        if (head == null) { // 头结点为空，直接添加头结点
            head = node;
        } else if (beforeNode == null) { // 如果前驱节点为空，或前驱节点值为空，默认在链表头插入
            node.next = afterNode;
            head = node;
        } else if (beforeNode.next != null) { // 中间插入
            afterNode = beforeNode.next;
            node.next = afterNode;
            beforeNode.next = node;
        } else { // 末尾插入
            node.next = null;
            beforeNode.next = node;
        }
        size++;
    }

    // 删除某个指定节点
    public void delete(Object object) throws ArrayException {
        if (object == null) {
            ExceptionUtil.throwArrayException("删除的目标对象不能为空！！！");
        }

        Node previousNode = head;// 前驱节点
        Node currentNode = head;// 当前节点
        while (!object.equals(currentNode.data)) {
            if (currentNode.next == null) {
                ExceptionUtil.throwArrayException("待删除的目标对象在链表中不存在！！！");
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (head.equals(currentNode)) { // 删除头结点
            head = head.next;
        } else { // 非头结点
            previousNode.next = currentNode.next;
        }
        size--;
    }

    // 寻找某个指定节点
    public Node findObject(Object object) throws ArrayException {
        if (isEmpty()) {
            return null;
        }
        Node currentNode = head;
        int tempSize = 0;
        while (tempSize < size) {
            if (object.equals(currentNode.data)) {
                break;
            }
            currentNode = currentNode.next;
            tempSize++;
        }
        return currentNode;
    }

    // 遍历链表并展示其值
    public void display() throws ArrayException {
        if (isEmpty()) {
            ExceptionUtil.throwArrayException("链表为空，无法进行遍历操作！！！");
        }
        Node currentNode = head;
        int tempSize = 0;
        while (tempSize < size) {
            if (currentNode.equals(head)) {
                System.out.print(currentNode.data);
            } else {
                System.out.print("->" + currentNode.data);
            }
            currentNode = currentNode.next;
            tempSize++;
        }
        System.out.println("=============");
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ArrayException {
        LinkedListStudy linkedList = new LinkedListStudy();
        linkedList.insert(null, 3);
        linkedList.insert(null, 2);
        linkedList.insert(null, 1);
        linkedList.display();
        linkedList.insert(2, 4);
        linkedList.display();
        linkedList.delete(4);
        linkedList.display();
        linkedList.delete(1);
        linkedList.display();
    }
}
