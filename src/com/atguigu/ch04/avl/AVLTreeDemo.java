package com.atguigu.ch04.avl;

public class AVLTreeDemo {

    public static void main(String[] args) {

//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        //创建AVLTree
        int[] arr = {10, 11, 7, 6, 8, 9};

        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历");
        avlTree.infixOrder();

       /* System.out.println("在没有平衡处理之前");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("左子树的高度：" + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度：" + avlTree.getRoot().rightHeight());*/

        System.out.println("在没有平衡处理之后");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("左子树的高度：" + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度：" + avlTree.getRoot().rightHeight());


    }
}


class AVLTree {
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




class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height())+ 1;
    }

    //左旋转方法  新左右值右左
    private void leftRotate() {
        //创建新的结点，以当前根节点的值
        Node newNode = new Node(value);
        //把新结点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新结点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        right = right.right;
        //把当前节点的左子树（左子节点）设置成新的结点
        left = newNode;
    }

    //右旋转  新右左值左右
    private void rightRotate() {
        //创建新的结点
        Node newNode = new Node(value);
        //右
        newNode.right = right;
        //左
        newNode.left = left.right;
        //值
        value = left.value;
        //左
        left = left.left;
        //右
        right = newNode;
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

        //当添加完一个节点后，如果右子树的高度-左子树的高度>1 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对当前节点的右子节点右旋转
                right.rightRotate();
                //再对当前节点进行左旋转
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        //当添加完一个节点后，如果左子树的高度-右子树的高度>1 右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前节点的左节点（左子树）->左旋转
                left.leftRotate();
                //再对当前节点进行右旋转
                rightRotate();
            } else {
                //直接进行右旋转即可
                rightRotate();
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