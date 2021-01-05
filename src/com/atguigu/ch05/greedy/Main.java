package com.atguigu.ch05.greedy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
 
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =  new Scanner(System.in);
		String str=in.nextLine();
		HashMap<Integer,String> m=new HashMap<Integer,String>();
		m.put(1930, "Uruguay");
		m.put(1938,"Italy");
		m.put(1954,"West Germany");
		m.put(1962, "Brazil");
		m.put(1986, "Argentina");
		//根据值来找键
		if(m.containsValue(str)==true) {
			//返回值类型Set<k>方法是： keySet():返回此映射中包含的键的 Set 集合
			//将map中所有的键存入到Set集合，因为set具备迭代器，所以可以用迭代方式取出所有的键
			//再根据get()方法,获取每一个键对应的值
			Set<Integer> keyset=m.keySet();
			Iterator<Integer> iterator=keyset.iterator();
			while (iterator.hasNext()) {
				Integer temp=iterator.next();
				if(m.get(temp).equals(str)){
                    System.out.println(temp);
                }
			}
		}
		else{
            System.out.println( str+" lose the championship!");
       }
}
} 