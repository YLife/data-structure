package com.yl.datastructure.Tree.RBTree;

public class RBNode<T extends Comparable<T>> {

    private String color;// 节点颜色
    private RBNode<T> leftNode;// 左子节点
    private RBNode<T> rightNode;// 又子节点
    private RBNode<T> parentNode;// 父节点
    private T value;// 节点值

    public RBNode(String color, RBNode<T> leftNode, RBNode<T> rightNode, RBNode<T> parentNode, T value) {
        this.color = color;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.parentNode = parentNode;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RBNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(RBNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public RBNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(RBNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public RBNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(RBNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{\"DATA:\"" + value + "\", \"COLOR:\"" + color + "\"}";
    }
}
