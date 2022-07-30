package top.puppetdev.da.leetcode.editor.cn.algos.sortion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：56 合并区间
 * @author puppet
 * @since 2022-07-29 21:12:03
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 我们用数组 merged 存储最终的答案。
     * 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
     * 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
     * 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
     * @TimeComplexity N
     * @SpaceComplexity N
     * @Classification 算法
     * @Tag 排序
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 先对 intervals 根据其左端点进行排序
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            // 声明二维数组 merged 用于存放结果，并先放一个数组进去比较
            List<int[]> merged = new ArrayList<>();
            merged.add(intervals[0]);
            for (int[] ints : intervals) {
                int[] lastOne = merged.get(merged.size() - 1);
                // 如果当前区间的左端点大于“合并数组”中最后一个区间的右端点，则说明两个区间没有重叠，将其添加到“合并数组”中，遍历下一个
                if (ints[0] > lastOne[1]) merged.add(ints);
                    // 否则说明区间覆盖，比较当前区间与“合并数据”中最后一个区间的右端点，将较大的右端点更新为“合并数据”中最后一个区间的右端点
                else lastOne[1] = Math.max(lastOne[1], ints[1]);
            }
            // 将 List<int[]> 转换为 int[][]
            return merged.toArray(new int[merged.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}