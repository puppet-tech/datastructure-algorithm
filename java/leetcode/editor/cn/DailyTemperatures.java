package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：739 每日温度
 *
 * @author puppet
 * @since 2023-04-02 18:11:29
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    ans[stack.peek()] = i - stack.pop();
                }
                stack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}