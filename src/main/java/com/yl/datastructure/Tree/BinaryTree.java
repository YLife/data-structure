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
    public boolean delete(Object object) throws ArrayException {
        // 找到被删除的节点
        Node currentNode = root;
        Node parentNode = currentNode;
        boolean isLeftNode = false;
        while (trans2Integer(currentNode.getData()) != trans2Integer(object)) {
            parentNode = currentNode;
            if (trans2Integer(object) > trans2Integer(currentNode.getData())) {
                currentNode = currentNode.getRightNode();
            } else if (trans2Integer(object) < trans2Integer(currentNode.getData())) {
                currentNode = currentNode.getLeftNode();
            } else {
                break;
            }
        }
        if (currentNode == null) {
            ExceptionUtil.throwArrayException("该节点在二叉树中不存在！！！");
        }
        // 被删除的节点为叶子节点
        // 被删除的节点只有左子节点
        // 被删除的节点只有右子节点
        // 被删除的节点左、右子节点都有
        return false;
    }

    // 获取最大值
    public int getMaxValue() throws ArrayException {
        Node currentNode = root;
        Node maxNode = currentNode;
        while (currentNode != null) {
            maxNode = currentNode;
            currentNode = currentNode.getRightNode();
        }
        return trans2Integer(currentNode.getData());
    }

    public int getMinValue() throws ArrayException {
        Node currentNode = root;
        Node minNode = currentNode;
        while (currentNode != null) {
            minNode = currentNode;
            currentNode = currentNode.getLeftNode();
        }
        return trans2Integer(currentNode.getData());
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
