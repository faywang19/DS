package com.leetcode.datastruc.treegraph;

import java.util.ArrayList;
import java.util.List;

public class Q938RangeSumBST {
    public static void main(String[] args) {
        TreeNode leftLeft = new TreeNode(3,null,null);
        TreeNode leftRight = new TreeNode(7,null,null);
        TreeNode rightRight = new TreeNode(18,null,null);
        TreeNode left = new TreeNode(5,leftLeft,leftRight);
        TreeNode right = new TreeNode(15,null,rightRight);
        TreeNode root = new TreeNode(10,left,right);
        int i = new Solution().rangeSumBST(root, 7, 15);
        System.out.println(i);



    }
}




class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

  }

class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            sum = rangeSumBST(root.right, low, high)+rangeSumBST(root.left, low, high)+root.val;
        }
        if (root.val <low ) {
            sum += rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            sum += rangeSumBST(root.left, low, high);
        }
        return sum;
    }
}