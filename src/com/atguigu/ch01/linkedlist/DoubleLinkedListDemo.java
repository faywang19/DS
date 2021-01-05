package com.atguigu.ch01.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        //1、先创建结点
        //先创建结点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //先创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();

        //按照顺序添加hero3
        System.out.println("添加3的结果");
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.list();
    }


}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    //显示链表（遍历）同单链表一样
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出结点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //添加一个链表到链表的最后
    public void add(HeroNode2 heroNode) {
        //因为head结点不能动，需要一个辅助变量
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出while循环时，temp指向了链表的最后
        //构成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改一个节点的内容,修改同单链表
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的结点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到了该节点
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的结点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            //没有找到
            System.out.printf("没有找到编号%d的结点，不能修改\n",newHeroNode);
        }
    }

    //从双向链表中删除一个节点
    //说明：1、对于双向链表可以直接找到要删除的这个节点
    //     2、找到后，自我删除即可

    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空,无法删除");
            return;
        }
        HeroNode2 temp = head.next;//辅助指针
        boolean flag = false;
        while (true) {
            if (temp ==null) {//已经到链表最后的next
                break;
            }
            if (temp.no == no) {
                //找到了删除节点本身
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //代码有问题
            //如果是最后一个节点，不需要执行下面，否则出现空指针异常
            if (temp.next != null) {
                temp.next.pre=temp.pre;
            }
            else{
                System.out.printf("要删除的%d节点不存在\n", no);
            }

        }
    }

    //第二种方式在添加英雄，根据排名将英雄插入到指定位置
    //有排名，添加失败，给出提示
    public void addByOrder(HeroNode2 heroNode) {
        //因为头结点不能动，因此仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //temp是位于添加位置的前一个结点，否则插入不了
        HeroNode2 temp = head;
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
            heroNode.pre = temp.next.pre;
            temp.next.pre = heroNode;
        }
    }




}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//默认为null
    public HeroNode2 pre;

    //构造器


    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法，重新toString

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}