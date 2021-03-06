package com.leetcode.binarySearch;

public class Qsearchinrotatedsortedarray {

    public int search(int[] nums,int target){
        int lo=0;
        int hi=nums.length-1;

        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            //当[0,mid]有序时，向后规约条件
            if(nums[0]<nums[mid]&&(target>nums[mid]||target<nums[0])){
                lo=mid-1;
                //当[0,mid]发生旋转时，向后规约条件
            }else if(target>nums[mid]&&target<nums[0]){
                lo=mid+1;
            }else{
                //其他情况，向前规约
                hi=mid;
            }
        }
        return lo==hi&&nums[lo]==target?lo:-1;
    }
}
