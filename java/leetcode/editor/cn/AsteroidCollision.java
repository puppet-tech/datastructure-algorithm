package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * 题目：735 行星碰撞
 *
 * @author puppet
 * @since 2023-04-05 20:39:03
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
        /*
        定义一个栈
        遍历数组
        如果遇到的是正整数，则放入栈中，如果是负整数且（栈为空或栈顶元素为负整数)，也放入栈中，
        如果是负整数且栈非空且栈顶元素为正整数，则取出栈顶元素比较碰撞
        碰撞后，如果爆炸，则继续遍历数组。如果剩下正整数，则将正整数放回栈后继续遍历；
        如果剩下负整数且(栈为空或栈顶元素为负整数)，也放入栈后继续遍历。如果剩下负整数且栈非空，则继续取出栈顶元素进行碰撞。
        最后返回栈
         */
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int len = asteroids.length;
            for (int i = 0; i < len; i++) {
                int num = asteroids[i];
                if (num > 0 || (num < 0 && (stack.isEmpty() || stack.peek() < 0))) stack.push(num);
                while (num < 0 && !stack.isEmpty() && stack.peek() > 0) {
                    // 进行碰撞
                    Integer pop = stack.pop();
                    int crash = pop + num;
                    if (crash == 0) break;
                    if (crash > 0) {
                        stack.push(pop);
                        break;
                    }
                    if (crash < 0 && (stack.isEmpty() || stack.peek() < 0)) {
                        stack.push(num);
                        break;
                    }
                }
            }
            int size = stack.size();
            int[] ans = new int[size];
            int i = size - 1;
            while (!stack.isEmpty()) {
                ans[i] = stack.pop();
                i--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}