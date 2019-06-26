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
        // 将二叉树重修为一颗RB树
        insertFixUp(node);
        return false;
    }


    public boolean delete(T value) {
        // TODO 删除待实现，考虑是真实删除节点还是将节点标记为无效？？
        return false;
    }

    private void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gradeParent;

        // 修正条件：父节点存在且父节点为红色
        while ((parent = node.getParentNode()) != null && CommonConst.RBTreeConst.RED.equals(parent.getColor())) {
            gradeParent = parent.getParentNode();
            RBNode<T> uncle;
            if (parent == gradeParent.getRightNode()) {
                 uncle = gradeParent.getLeftNode();
                // 如果叔叔节点也是红色，先进行变色
                if (uncle != null && CommonConst.RBTreeConst.RED.equals(uncle.getColor())) {
                    parent.setColor(CommonConst.RBTreeConst.BLACK);
                    uncle.setColor(CommonConst.RBTreeConst.BLACK);
                    gradeParent.setColor(CommonConst.RBTreeConst.RED);
                    node = gradeParent;
                    continue;
                }
                // 如果叔叔节点是黑色，父节点为右子节点
                if (node == parent.getLeftNode()) {
                    leftRotate(parent);
                    RBNode<T> tmp = parent;// 交换父节点，为后面的右旋做准备
                    parent = tmp;
                    node = tmp;
                }
                // 如果叔叔节点是黑色，父节点为左子节点
                parent.setColor(CommonConst.RBTreeConst.BLACK);
                gradeParent.setColor(CommonConst.RBTreeConst.RED);
                rightRotate(gradeParent);
            } else {
                uncle = parent.getRightNode();
                if (uncle != null && CommonConst.RBTreeConst.RED.equals(uncle.getColor())) {
                    parent.setColor(CommonConst.RBTreeConst.BLACK);
                    uncle.setColor(CommonConst.RBTreeConst.BLACK);
                    gradeParent.setColor(CommonConst.RBTreeConst.RED);
                    node = gradeParent;
                    continue;
                }
                if (node == gradeParent.getLeftNode()) {
                    rightRotate(gradeParent);
                    RBNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }
                parent.setColor(CommonConst.RBTreeConst.BLACK);
                gradeParent.setColor(CommonConst.RBTreeConst.RED);
                leftRotate(gradeParent);
            }
        }
    }

    /**
     *  左旋
     *
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     *
     *
     */
    private void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.getRightNode();
        x.setLeftNode(y.getLeftNode());
        if (y.getLeftNode() != null) {
            y.getLeftNode().setParentNode(x);
        }
        y.setParentNode(x.getParentNode());
        if (x.getParentNode() == null) {
            root = y;
        } else {
            if (x.getParentNode().getLeftNode() == x) {
                x.getParentNode().setLeftNode(y);
            } else {
                x.getParentNode().setRightNode(y);
            }
        }
        x.setParentNode(y);
        y.setLeftNode(x);
    }

    /**
     *  右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     *
     *
     */
    private void rightRotate(RBNode<T> y) {
        RBNode<T> x = y.getRightNode();
        y.setLeftNode(x.getRightNode());
        if (x.getRightNode() != null) {
            x.getRightNode().setParentNode(y);
        }
        x.setParentNode(y.getParentNode());
        if (y.getParentNode() == null) {
            root = x;
        } else {
            if (y.getParentNode().getLeftNode() == y) {
                y.getParentNode().setLeftNode(x);
            } else {
                y.getParentNode().setRightNode(x);
            }
        }
        y.setParentNode(x);
        x.setRightNode(y);
    }

    private int compareValue(T orgin, T target) {
        return orgin.compareTo(target);
    }
}
