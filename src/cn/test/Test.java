package cn.test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        Solution4 solution4 = new Solution4();
        Solution5 solution5 = new Solution5();
        Math.max(1, 2);
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
        System.out.println(solution1.threeSum(nums));
        System.out.println(solution2.threeSum(nums));
        System.out.println(solution3.threeSum(nums));
        System.out.println(solution4.threeSum(nums));
        System.out.println(solution5.threesum(nums));
    }


}

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
//        Arrays.sort(nums);
        Set<List<Integer>> resSet = new LinkedHashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]==nums[k]*(-1)){
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        resSet.add(value);
                    }
                }
            }

        }
        return new ArrayList<>(resSet);

    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> resSet = new LinkedHashSet<>();

        for (int i = 0; i < nums.length-1; i++) {
            map.put(nums[i], i);
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);
                if (map.containsKey(complement)) {
                    List<Integer> val = Arrays.asList(nums[i], nums[j], nums[map.get(complement)]);
                    resSet.add(val);
                }
            }
        }

        return new ArrayList<>(resSet);

    }
}


class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> resSet = new LinkedHashSet<>();
        Arrays.sort(nums);
        //双指针
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> value = Arrays.asList(nums[i], nums[head], nums[tail]);
                    resSet.add(value);
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return new ArrayList<>(resSet);

    }
}


class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        //双指针
        for (int i = 0; i < nums.length - 2; i++) {
            //第一个大于0则肯定不行
            if (nums[i] > 0) {
                return res;
            }
            //跳过计算过的数据，防止结果重复
            if (i > 0 && nums[i]==nums[i - 1]) {
                continue;
            }
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }

        }

        return res;

    }
}

class Solution4{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                Integer value = -nums[i] - nums[j];
                if (set.contains(value)) {
                    ans.add(Arrays.asList(nums[i], value, nums[j]));
                    while ((j + 1) < nums.length && nums[j] == nums[j + 1]) {
                        ++j;
                    }
                } else set.add(nums[j]);
            }
            set.clear();
        }
        return ans;
    }

}
class Solution5 {

    public List<List<Integer>> threesum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums[i], i);
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);
                if (map.containsKey(complement)) {
                    List<Integer> val = Arrays.asList(nums[i], nums[j], nums[map.get(complement)]);
                    res.add(val);
                }
            }
        }

        return new ArrayList<>(res);
    }

}