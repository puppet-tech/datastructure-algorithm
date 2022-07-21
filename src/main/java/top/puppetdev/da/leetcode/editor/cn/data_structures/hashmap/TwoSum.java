package top.puppetdev.da.leetcode.editor.cn.data_structures.hashmap;

import java.util.HashMap;

/**
 * 题目：1 两数之和
 * @author puppet
 * @since 2022-07-21 11:48:58
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * @TimeComplexity N Only need to traverse once
     * @SpaceComplexity N need a hashmap to store the elements which has been traversed
     * @Classification hashmap
     * @Tag hashmap
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            
            HashMap<Integer, Integer> map = new HashMap<>();
            int length = nums.length;
            
            // the core code, need to think carefully
            for (int i = 0; i < length; i++) {
                if (map.containsKey(target - nums[i])) return new int[]{i, map.get(target - nums[i])};
                else map.put(nums[i], i);
            }
            
            // if no such array exists, return an empty array
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}