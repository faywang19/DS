package com.atguigu.ch04.binarysorttree.practice;

public class BinarySortTreeDemo {

    public static void main(String[] args) {

    }

}

//2、创建树
class BinarySortTree{
    private Node root;

    //二叉树的添加和中序遍历方法主要是消除空树null的warning
    //添加时，从空的开始创建，对空赋值，遍历时，空的返回异常，其他正常。

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树");
        }
    }

}



//1、创建结点

class Node {
     int value;
     Node left;
     Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    //递归添加,添加的过程其实就是创建的过程
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value <= this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }


    //中序遍历infix
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}