package leetcode.editor.cn.data_structures.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：232 用栈实现队列
 * @author puppet
 * @since 2022-07-19 21:13:51
 */
public class ImplementQueueUsingStacks {
    // public static void main(String[] args) {
    //     Solution solution = new ImplementQueueUsingStacks().new Solution();
    // }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * @Classification stack and queue
     * @Tag
     * @Solution 1. define two stacks
     *         2. if push elements, add the element too s1.
     *         3. if pop elements, get the element from s2.
     * @TimeComplexity
     * @SpaceComplexity
     */
    class MyQueue {

        private Deque<Integer> s1;
        private Deque<Integer> s2;

        public MyQueue() {
            this.s1 = new ArrayDeque<>();
            this.s2 = new ArrayDeque<>();
        }

        public void push(int x) {
            this.s1.push(x);
        }

        public int pop() {
            if (empty()) return 0;
            if (!s2.isEmpty()) return s2.pop();
            else {
                // move all elements of s1 to s2
                int size = s1.size();
                for (int i = 0; i < size; i++) {
                    s2.push(s1.pop());
                }
                return s2.pop();
            }
        }

        public int peek() {
            if (empty()) return 0;
            if (!s2.isEmpty()) return s2.peek();
            else {
                // move all elements of s1 to s2
                int size = s1.size();
                for (int i = 0; i < size; i++) {
                    s2.push(s1.pop());
                }
                return s2.peek();
            }
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}