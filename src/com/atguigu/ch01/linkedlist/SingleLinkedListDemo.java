package com.atguigu.ch01.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        //先创建结点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //测试反转
        System.out.println("原来链表：");
        singleLinkedList.list();

      /*  System.out.println("反转链表！！");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();*/
/*
        //加入按照编号
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);

        //显示
        singleLinkedList.list();

        //测试修改的节点
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的的链表情况");

        singleLinkedList.list();

        //删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除后的链表情况");
        singleLinkedList.list();

        //测试求单链表中有效结点的个数
        System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));

        //测试一下看看是否得到了倒数第K个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println("res=" + res);

 */
        System.out.println("测试逆序打印单链表");
        reversePrint(singleLinkedList.getHead());
//        singleLinkedList.list();//链表本身没有发生变化
}

    //方式2：
    //利用栈数据结构，将各个节点压入栈中，利用先进后出的特点，实现逆序打印的效果
    public static void  reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表不打印
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur!= null) {
            stack.push(cur);
            cur = cur.next;//cur后移，这样可以压入下一个结点
        }
        //将栈中的结点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());//先进后出
        }
    }






    //将单链表反转
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针（变量），帮助遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点cur的下一个结点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的最前端
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个结点，后面需要使用
            cur.next= reverseHead.next;//将cur的下一个结点指向链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }


    //查找单链表的倒数第K个结点（新浪面试题）
    //思路
    //1，编写一个方法，接收head结点，同时接收一个index
    //2、index表示是倒数第index个结点
    //3、先把链表从头到尾遍历，得到链表的总长度getLength
    //4、得到size后，从链表的第一个开始遍历(size-index）个，就可以得到
    //5、如果找到了，返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;
        }
        //第一个遍历得到链表的长度(结点个数)
        int size = getLength(head);
        //第二次遍历size-index位置，就是倒数的第k个结点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }








    //方法：获取到单链表的结点的个数（如果是带头结点的链表，需要不统计头结点）

    /**
     *
     * @param head  链表的头结点
     * @return   返回的是有效结点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {//空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量，这里没有统计头结点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;//遍历
        }
        return length;
    }}

//定义SingleLinkedList 管理英雄
class SingleLinkedList{
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //1、找到当前链表的最后节点
    //2、将最后这个节点的next指向新的结点
    public void add(HeroNode heroNode) {
        //因为head结点不能动，因此需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的结点
        temp.next = heroNode;
    }
    //第二种方式在添加英雄，根据排名将英雄插入到指定位置
    //有排名，添加失败，给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，因此仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //temp是位于添加位置的前一个结点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已经存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号存在
            System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n", heroNode.no);
        }else{
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1、根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义了一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{//没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }

    }

    //删除节点
    //思路
    //1、head不能动，需要一个辅助节点找到删除节点的前一个结点
    //2、说明在比较时，是temp.next.no和需要删除的结点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到了待删除节点的一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判断flag
        if (flag) {//找到
            //可以删除
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的%d结点不存在\n", no);
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点，不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }//输出节点的信息
            System.out.println(temp);
            //将temp后移,否则死循环
            temp = temp.next;
        }
    }

}



//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }



    //为了显示放变，重写toString


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
