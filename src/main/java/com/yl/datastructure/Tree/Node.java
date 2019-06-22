package com.yl.datastructure.Tree;

/**
 * 二叉树节点
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/16 23:56
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/16      yanglun            v1.0.0              修改原因
 */
public class Node {

    private int data;// 节点数据
    private Node leftNode;// 左子节点
    private Node rightNode;// 右子节点

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    // 打印当前节点的值
    public void display() {
        System.out.println("当前节点值为：" + data);
    }
}
