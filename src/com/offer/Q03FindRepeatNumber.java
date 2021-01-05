package com.offer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.image.BandedSampleModel;
import java.util.*;

//找出重复的数
public class Q03FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int [] nums2=new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        int[] repeatNumber = new Solution().findRepeatNumber(nums);
//        for (int ele : repeatNumber) {
//            System.out.print(ele);
//        }
        List repeatNumber = new Solution().findRepeatNumber(nums);
//        System.out.println(repeatNumber);
        System.out.println(new Solution2().findRepeatNumber(nums2));
    }

}

class Solution {
    public List findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int[] ints = new int[nums.length];
        List<Integer> lists = new ArrayList<>();
        for (int ele : nums) {
            if (map == null) {
                map.put(ele, 1);
            }
            if (map.containsKey(ele)) {
                lists.add(ele);
            } else {
                map.put(ele, 1);
            }
        }
        return lists;
    }
}

class Solution1 {
    public int findRepeatNumber1(int[] nums) {
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            if (set.isEmpty()) {
                set.add(ele);
            } else if (set.contains(ele)) {
                ans = ele;
            } else {
                set.add(ele);
            }
        }
        return ans;
    }
}

class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
