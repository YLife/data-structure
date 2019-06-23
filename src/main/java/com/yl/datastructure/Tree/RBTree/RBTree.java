package com.yl.datastructure.Tree.RBTree;

import com.yl.common.ArrayException;
import com.yl.common.CommonConst;
import com.yl.common.ExceptionUtil;

public class RBTree<T extends Comparable<T>> {

    private RBNode<T> root;

    // 查找节点
    public RBNode<T> find(T value) throws ArrayException {
        RBNode<T> currentNode = root;
        while (currentNode != null) {
            int cmpResult = compareValue(currentNode.getValue(), value);
            if (cmpResult < 0) {
                currentNode = currentNode.getLeftNode();
            } else if (cmpResult > 0) {
                currentNode = currentNode.getRightNode();
            } else {
                break;
            }
        }
        if (currentNode == null) {
            ExceptionUtil.throwArrayException("该节点在红黑树中不存在！！");
        }
        return currentNode;
    }

    // 插入节点
    public boolean insert(T value) {
        RBNode<T> node = new RBNode<T>(CommonConst.RBTreeConst.RED, null, null, null, value);
        // 查找插入的位置
        RBNode<T> targetNode = null;
        RBNode<T> currenNode = root;
        while (currenNode != null) {
            targetNode = currenNode;
            int cmpResult = compareValue(currenNode.getValue(), value);
            if (cmpResult < 0) {
                currenNode = currenNode.getLeftNode();
            } else {
                currenNode = currenNode.getRightNode();
            }
        }
        node.setParentNode(targetNode);
        if (targetNode == null) {
            root = node;
        } else {
            // 判断待插入的节点是左子节点还是右子节点
            int cmpResult = compareValue(value, targetNode.getValue());
            if (cmpResult < 0) {
                targetNode.setLeftNode(node);
            } else {
                targetNode.setRightNode(node);
            }
        }
        // TODO 将二叉树重修修为一颗RB树
        return false;
    }

    // 删除节点
    public boolean delete(T value) {

        return false;
    }

    private int compareValue(T orgin, T target) {
        return orgin.compareTo(target);
    }
}
