package top.puppetdev.da.leetcode.editor.cn.data_structures.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：227 基本计算器 II
 * @author puppet
 * @since 2022-07-19 23:20:29
 */
public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate(" 3/2 "));
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 1. define two stacks, one for operators and the other for data
     * 2. traverse the input string, push operators into the operator stack, push data into the data stack.
     * 3. every time encounter operators, make it compared with the top element of the operator stack. if the priority
     * is higher, push it into the operator stack， otherwise, pop two elements from the data stack and pop an element
     * from the operator stack to calculate. then push the result of calculation into the data stack.
     * finally, continue make the operator compared with the top element of the operator stack.
     * @TimeComplexity N
     * @SpaceComplexity N
     * @Classification stack and queue
     * @Tag math, stack
     */
    class Solution {
        public int calculate(String s) {
            s = s.trim();
            
            Deque<Integer> data = new ArrayDeque<>();
            char preSign = '+';
            
            int length = s.length();
            int num = 0;
            
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;
                if (Character.isDigit(c)) num = num * 10 + (c - '0');
                if (!Character.isDigit(c) || i == length - 1) {
                    switch (preSign) {
                        case '+':
                            data.push(num);
                            break;
                        case '-':
                            data.push(-num);
                            break;
                        case '*':
                            data.push(data.pop() * num);
                            break;
                        case '/':
                            data.push(data.pop() / num);
                            break;
                    }
                    num = 0;
                    preSign = c;
                }
            }
            int ans = 0;
            while (!data.isEmpty()) ans += data.pop();
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}