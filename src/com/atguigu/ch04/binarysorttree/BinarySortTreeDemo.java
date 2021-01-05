package com.atguigu.ch04.binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历");
        binarySortTree.infixOrder();

        System.out.println("=============");

        //测试删除叶子结点
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        System.out.println(binarySortTree.getRoot());
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);
        System.out.println("删除后的中序遍历");
        binarySortTree.infixOrder();
    }
}

/**
 * delNode的三种情况(都需要找到targetNode和parent)
 * i.  删除叶子结点
 *                  确定targetNode是左子节点还是右子节点
 * ii.  删除只有一颗子树的结点
 * iii.删除有两颗子树的结点
 *      从targetNode的右子树找到最小的结点作为temp进行targetNode赋值
 *      or 左子树的最大结点
 *
 *
 */
//创建二叉排序树
class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    /**编写方法：
     * 1、返回的以node为根节点的二叉排序树的最小结点的值
     * 2、删除node为根节点的二叉排序树的最小节点
     *
     * @param node  传入结点(当做二叉排序树的根节点）
     * @return  返回的以node为结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时target就指向了最小节点
        //删除最小节点
        delNode(target.value);
        return target.value;
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1、需要先找到targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前这可二叉排序树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //找到targetNode的父节点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断target是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {//左子节点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {//右子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //删除有两颗子树
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;

            } else {//删除只有一颗子树的结点
                //如果要删除的结点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {//如果targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {//如果要删除的结点有右子节点
                    if (parent != null) {
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {//如果targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }

            }
        }
    }

    //添加节点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空，直接让root指向node
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树");
        }
    }
}









//创建Node结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     *
     * @param value  希望删除节点的值
     * @return   如果找到返回该节点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {//找到就是该节点
            return this;
        } else if (value < this.value) {
            //如果左子节点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     *
     * @param value 要找到节点的值
     * @return   返回的要删除节点的父节点，如果没有就返回null
     */
    //查找要删除节点的父节点
    public Node searchParent(int value) {
        //如果当前的结点就是要删除节点的父节点就返回
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;//没有找到父节点
            }
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //递归添加
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }else{
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

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
