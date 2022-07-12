package top.puppetdev.da.leetcode.editor.cn.data_structures.stack_queue;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * @author puppet
 * @since 2022/3/28 12:02
 */
public class LC20ValidParentheses {
    /**
     * @Tag 栈、散列表
     * @Solution 准备一个栈 bracketStack，遍历 s，当遇到左括号时，将其放入栈中，
     *         遇到右括号时，检查是否栈顶元素括号是否与之匹配，
     *         如果匹配，则删除栈顶元素，继续遍历，如果不匹配，说明 s 存在无效括号，直接返回 false
     * @Tip
     * @TimeComplexity O(N) —— N 为 s 长度
     * @SpaceComplexity O(N) —— N 为 s 长度
     */
    public static boolean solve(String s) {
        Stack<Character> bracketStack = new Stack<>();
        final HashMap<Character, Character> bracketMap = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        for (int i = 0; i < s.length(); i++) {
            // 当前遍历到的符号
            char c = s.charAt(i);
            if (bracketMap.containsKey(c)) bracketStack.push(c);
            else {
                // 如果此时遍历到的是 右括号，而栈中已经没有元素，则直接说明不匹配
                if (bracketStack.isEmpty()) return false;
                // 如果存在一组不匹配，直接返回 false
                if (c != bracketMap.get(bracketStack.pop())) return false;
            }
        }
        // 最后如果栈为空，说明全部匹配成功，是一组有效括号，否则为无效括号
        return bracketStack.isEmpty();
    }
}
