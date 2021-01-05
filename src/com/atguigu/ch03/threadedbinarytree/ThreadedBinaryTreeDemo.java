package com.atguigu.ch03.threadedbinarytree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode heroNode2 = new HeroNode(3, "jack");
        HeroNode heroNode3 = new HeroNode(6, "smith");
        HeroNode heroNode4 = new HeroNode(8, "mary");
        HeroNode heroNode5 = new HeroNode(10, "king");
        HeroNode heroNode6 = new HeroNode(14, "dim");

        //
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);

        heroNode3.setLeft(heroNode6);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试：10号
        HeroNode leftNode = heroNode5.getLeft();
        System.out.println("10号结点的前驱结点"+leftNode);
        HeroNode rightNode = heroNode5.getRight();
        System.out.println("10号结点的后驱结点"+rightNode);
        System.out.println("==================");
        threadedBinaryTree.threadedList();//8

    }









}

class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建要给指向当前节点的前驱结点的指针
    //在递归进行线索化，pre总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType==1的结点，第一个找到的就是8结点
            //后面随着遍历而变化，因为当leftType==1时说明该节点是按照线索化
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个结点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继结点，一直输出
            while (node.getRightType() == 1) {
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();
        }
    }

    //编写对二叉树进行中序线索化的方法

    /**
     *
     * @param heroNode  就是当前线索化的结点
     */
    public void threadedNodes(HeroNode heroNode) {
        //如果node==null，不能线索化
        if (heroNode == null) {
            return;
        }
        //1、先线索化左子树
        threadedNodes(heroNode.getLeft());
        //2、线索化当前节点
        //处理当前节点的前驱结点
        if (heroNode.getLeft() == null) {
            //让当前节点的左指针指向前驱结点
            heroNode.setLeft(pre);
            heroNode.setLeftType(1);
        }
        //处理后继结点
        if (pre!=null&&pre.getRight() == null) {
            //让前驱结点的右指针指向当前节点
            pre.setRight(heroNode);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个结点后，让当前节点是一个结点的前驱结点
        pre = heroNode;


        //3、线索化右子树
        threadedNodes(heroNode.getRight());





    }


















    //删除节点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root节点，判断是不是要删除的结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空数，不能删除");
        }

    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOerderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearc(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }


}

//先创建HeroNode结点
class HeroNode {
        private int no;
        private String name;
        private HeroNode left;//默认为null
        private HeroNode right;//默认为null


    //说明
//    1、如果leftType==0,表示指向的是左子树，如果是1则表示指向前驱结点
//    2、如果rightType==0，表示指向的是右子树，如果1表示指向后继结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }


    public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
    }

    //递归删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.right = null;
            return;
        }

        if (this.right != null & this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }

        if (this.right != null) {
            this.right.delNode(no);
        }

    }

        //编写前序遍历的方法
        public void preOrder() {
            System.out.println(this);//先输出父节点
            //递归向左子树前序遍历
            if (this.left != null) {
                this.left.preOrder();
            }
            //递归向右子树前序遍历
            if (this.right != null) {
                this.right.preOrder();
            }
        }


        //中序遍历
        public void infixOrder() {
            //递归向左子树中序遍历
            if (this.left != null) {
                this.left.infixOrder();
            }
            //输出父节点
            System.out.println(this);
            //递归向右子树中序遍历
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        //后序遍历
        public void postOrder() {
            //递归向左子树中序遍历
            if (this.left != null) {
                this.left.postOrder();
            }
            //递归向左子树中序遍历
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }


        //前序查找

        /**
         *
         * @param no 查找no
         * @return  如果找到就返回，没有找到就返回null
         */
        public HeroNode preOerderSearch(int no) {
            System.out.println("进入前序遍历");
            //比较当前节点是不是
            if (this.no == no) {
                return this;
            }
            HeroNode resNode = null;
            if (this.left != null) {
                resNode=this.left.preOerderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            //1、左递归前序查找，找到节点则返回，否则继续判断
            //2、当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
            if (this.right != null) {
                resNode=this.right.preOerderSearch(no);
            }
            return resNode;
        }


        //中序遍历查找
        public HeroNode infixOrderSearch(int no) {
            //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
            HeroNode resNode = null;

            if (this.left != null) {
                resNode = this.left.infixOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            //如果找到则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点
            System.out.println("进入中序遍历");
            if (this.no == no) {
                return this;
            }
            if (this.right != null) {
                resNode = this.right.infixOrderSearch(no);
            }
            return resNode;
        }

        //后序遍历查找
        public HeroNode postOrderSearch(int no) {
            //判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.postOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            //如果左子树没有找到，则向右子树递归进行后序遍历查找
            if (this.right != null) {
                resNode = this.right.postOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            //如果左右子树都没有找到，比较当前节点
            System.out.println("进入后序遍历查找");
            if (this.no == no) {
                return this;
            }
            return resNode;
        }
    }


