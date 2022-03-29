package org.example.data.structures.hashmap;

import java.util.HashMap;

/**
 * 两数之和
 * @author puppet
 * @since 2022/3/19 17:39
 */
public class LC1TwoSum {
    /**
     * @Tag
     * @Solution 暴力解决
     *         遍历整个数组，从头到尾，分别取出一个数，让 target 减去，剩下的就是另一个数的值
     *         再次遍历数组，找到另一个数的位置
     * @Tip
     * @TimeComplexity O(N ^ 2)
     * @SpaceComplexity O(1)
     */
    public static int[] solve(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            // 取出的值 nums[i] 不需要跟 i 之前的数进行比较，故 j 从 i + 1 开始
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == another) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
    /**
     * @Tag 散列表
     * @Solution 推荐做法
     *         遍历数组，每取出一个数 nums[i]，就判断 target - nums[i] 是否在散列表中
     *         如果在，则直接返回，如果不在，则将 nums[i] 作为 key，i 作为 value 存入散列表中
     * @Tip
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public static int[] solve2(int[] nums, int target) {
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                return new int[]{hashmap.get(target - nums[i]), i};
            }
            hashmap.put(nums[i], i);
        }
        return new int[0];
    }
}
