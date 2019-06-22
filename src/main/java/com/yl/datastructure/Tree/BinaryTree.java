package com.yl.datastructure.Tree;

import com.yl.common.ArrayException;
import com.yl.common.ExceptionUtil;

public class BinaryTree implements Tree {

    private Node root;

    @Override
    public Node find(int data) throws ArrayException {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.getData() < data) {
                currentNode = currentNode.getRightNode();
            } else if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftNode();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) throws ArrayException {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return true;
        }
        Node currentNode = root;
        Node parentNode;
        while (currentNode.getData() != data) {
            parentNode = currentNode;
            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftNode();
                if (currentNode == null) {
                    parentNode.setLeftNode(node);
                    return true;
                }
            } else {
                currentNode = currentNode.getRightNode();
                if (currentNode == null) {
                    parentNode.setRightNode(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(int data) throws ArrayException {
        // 找到需要删除的节点
        Node currentNode = root;
        Node parentNode = currentNode;
        boolean isLeftNode = false;
        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftNode();
                if (currentNode.getData() == data) {
                    isLeftNode = true;
                    break;
                }
            } else if (currentNode.getData() < data) {
                currentNode = currentNode.getRightNode();
                if (currentNode.getData() == data) {
                    break;
                }
            }
        }
        if (currentNode == null) {
            return false;
        }
        if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) { // 左、右子节点为空
            if (isLeftNode) {
                parentNode.setLeftNode(null);
            } else {
                parentNode.setRightNode(null);
            }
            return true;
        } else if (currentNode.getLeftNode() != null && currentNode.getRightNode() == null) { // 左子节点不为空，右子节点为空
            if (isLeftNode) {
                parentNode.setLeftNode(currentNode.getLeftNode());
            } else {
                parentNode.setRightNode(currentNode.getLeftNode());
            }
            return true;
        } else if (currentNode.getRightNode() != null && currentNode.getLeftNode() == null) { // 右子节点不为空，左子节点为空
            if (isLeftNode) {
                parentNode.setLeftNode(currentNode.getRightNode());
            } else {
                parentNode.setRightNode(currentNode.getRightNode());
            }
            return true;
        } else { // 左、右子节点都不为空
            // 获取删除节点后的后继节点
            Node successor = getSuccessor(currentNode);
            infixOrder(successor);
            if (isLeftNode) {
                parentNode.setLeftNode(successor);
            } else {
                parentNode.setRightNode(successor);
            }
            successor.setLeftNode(currentNode.getLeftNode());
        }
        return true;
    }

    // 获取删除后的后继节点
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightNode();
        // 寻找删除节点右子树的最左子节点
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }
        if (successor != delNode.getRightNode()) {
            successorParent.setLeftNode(successor.getRightNode());
            successor.setRightNode(delNode.getRightNode());
        }
        return successor;
    }

    @Override
    public void infixOrder(Node current){
        if(current != null){
            infixOrder(current.getLeftNode());
            System.out.print(current.getData() + " ");
            infixOrder(current.getRightNode());
        }
    }

    @Override
    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.getData() + " ");
            preOrder(current.getLeftNode());
            preOrder(current.getRightNode());
        }
    }

    @Override
    public void postOrder(Node current){
        if(current != null){
            postOrder(current.getLeftNode());
            postOrder(current.getRightNode());
            System.out.print(current.getData() + " ");
        }
    }


    public static void main(String[] args) throws ArrayException {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(15);
        binaryTree.insert(19);
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(12);
        binaryTree.insert(9);
        binaryTree.insert(13);
        binaryTree.insert(10);
        binaryTree.infixOrder(binaryTree.root);
        System.out.println("===");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("===");
        binaryTree.postOrder(binaryTree.root);
        System.out.println("===");
        Node node = binaryTree.find(10);
        System.out.println(node.getData());
        binaryTree.delete(7);
        System.out.println("===测试两个子节点场景===");
        binaryTree.infixOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
        binaryTree.delete(4);
        System.out.println("===测试一个子节点场景===");
        binaryTree.infixOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
        binaryTree.delete(5);
        System.out.println("===测试无子节点场景===");
        binaryTree.infixOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
    }

}
