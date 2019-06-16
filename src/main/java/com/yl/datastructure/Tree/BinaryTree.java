package com.yl.datastructure.Tree;

import com.yl.common.ArrayException;
import com.yl.common.ExceptionUtil;

public class BinaryTree implements Tree {

    private Node root;

    @Override
    public Node find(Object object) throws ArrayException {
        Node currentNode = root;
        while (currentNode != null) {
            if (trans2Integer(currentNode.getData()) < trans2Integer(object)) {
                currentNode = currentNode.getRightNode();
            } else if (trans2Integer(currentNode.getData()) > trans2Integer(object)) {
                currentNode = currentNode.getLeftNode();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public boolean insert(Object object) throws ArrayException {
        Node node = new Node(object);
        if (root == null) {
            root = node;
        } else {
            Node currentNode = root;
            Node parentNode = null;
            while (currentNode != null) {
                parentNode = currentNode;
                if (trans2Integer(currentNode.getData()) < trans2Integer(object)) {
                    currentNode = currentNode.getRightNode();
                    if (currentNode == null) {
                        parentNode.setRightNode(node);
                        return true;
                    }
                } else if (trans2Integer(currentNode.getData()) > trans2Integer(object)) {
                    currentNode = currentNode.getLeftNode();
                    if (currentNode == null) {
                        parentNode.setLeftNode(node);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object object) {

        return false;
    }

    // 将对象转换为integer
    private Integer trans2Integer(Object object) throws ArrayException {
        Integer number = null;
        try {
            number = (Integer) object;
        } catch (Exception e) {
            ExceptionUtil.throwArrayException("操作的对象不是number型的！！！");
        }
        return number;
    }

}
