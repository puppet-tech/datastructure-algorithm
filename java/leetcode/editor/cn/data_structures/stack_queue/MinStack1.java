package leetcode.editor.cn.data_structures.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：155 最小栈
 * @author puppet
 * @since 2022-07-19 22:31:54
 */
public class MinStack1 {
    public static void main(String[] args) {
        // MinStack minStack = new leetcode.editor.cn.data_structures.stack_queue.MinStack().new MinStack();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * @Classification stack and queue
     * @Tag
     * @Solution maintain a stack auxiliary stack to store the minimum
     * @TimeComplexity
     * @SpaceComplexity
     */
    class MinStack {

        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                minStack.push(val);
            } else {
                // if stack is not empty
                int min = Math.min(val, minStack.peek());
                minStack.push(min);
            }
            // whether it is empty or not, it should be added to the stack
            stack.push(val);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}