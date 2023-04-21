package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：554 砖墙
 *
 * @author puppet
 * @since 2023-04-05 02:29:09
 */
public class BrickWall {
    public static void main(String[] args) {
        Solution solution = new BrickWall().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            int size = wall.size();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                int sum = 0;
                for (Integer num : wall.get(i)) {
                    sum += num;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
                map.remove(sum); // 不能从两边穿过，所以需要 remove 最后一个
            }
            int max = 0;
            for (Integer value : map.values()) {
                max = Math.max(max, value);
            }
            return size - max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}