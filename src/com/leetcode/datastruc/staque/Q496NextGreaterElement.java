package com.leetcode.datastruc.staque;

import javax.imageio.stream.ImageInputStream;
import java.util.*;

public class Q496NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1=new int[]{4,1,2};
        int[] nums2=new int[]{1,3,4,2};
        int[] nums3=new int[]{1,3,5,2,4};
        int[] nums4=new int[]{6,5,4,3,2,1,7,8,9,10};

       int[] b=(new Solution()).nextGreaterElement(nums3,nums4);
        /*for(int element:b){
            System.out.println(element);
        }*/
        System.out.println(Arrays.toString(b));
    }

    /**
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     *
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     *
     * @param nums1 nums2的子集
     * @param nums2
     * @return
     */


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] ans = new int[l1];
        for (int i = 0;i<l1;i++){
            int x = -1;
            for(int j = i;j<l2;j++){
                if(nums1[i]==nums2[j]){
                    x = j;
                    break;
                }
            }
            int y = -1;
            int n2 = nums2[x];
            for(int k = x+1;k<l2;k++){
                if(nums2[k]>n2){
                    y = nums2[k];
                    break;
                }
            }
            ans[i] = y;
        }
        return ans;
    }



    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int ele : nums1) {
            queue.add(ele);
        }
        for (int ele1 : nums2) {
            stack.push(ele1);
        }
        for (int i = 0; i <nums1.length ; i++) {
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                int top = stack.peek();
                int afterMax = top;
                if (top == poll) {
                    ans[i] = -1;
                }
                while (top != poll) {
                    int temp=stack.pop();
                    if (temp >=top) {
                        afterMax = temp;
                    }
                }
                ans[i] = afterMax;
            }
            break;
        }
        return ans;
    }



}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = nextGreaterHelper(nums2);
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    private Map<Integer, Integer> nextGreaterHelper(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();  // 存放高个元素的栈
        for (int i = nums.length - 1; i >= 0; i--) {  // 倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();  // 矮个起开，反正也被挡着了
            }

            map.put(nums[i], stack.isEmpty() ? -1 : stack.peek());  // 当前元素身后的第一个高个
            stack.push(nums[i]);  // 进队，接受之后的身高判定
        }

        return map;
    }
}
