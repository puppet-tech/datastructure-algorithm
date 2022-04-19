package dev.puppet.data_structures.string;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import sun.security.util.Length;

/**
 * 字符串转换整数
 * @author puppet
 * @since 2022/4/3 18:12
 */
public class LC8StringToIntegerATOI {
    /**
     * @Tag 字符串
     * @Solution 这道题主要是考察对数据的处理，并没有用到什么算法
     *         1. 需要去掉前导空格
     *         2. 判断第 1 个字符为 + 和 - 的情况。可以设计一个 sign 变量存储，初始值为 1，如果遇到 "-"，则改为 -1
     *         3. 判断是否为数字，采用 ASCII 码进行判断即可：'0' <= c <= '9'
     *         4. 如果不是数字，则停止遍历
     * @Tip 注意事项：转换前需要判断是否整数溢出了
     * @TimeComplexity O(N) —— N 为 s.length()
     * @SpaceComplexity O(1)
     */
    public static int solve(String s) {
        int index = 0, sign = 1, result = 0;
        // 先忽略前导空格
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        // 判断 + 和 - 的情况
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        // 开始转换
        while (index < s.length() && '0' <= s.charAt(index) && s.charAt(index) <= '9') {
            int currentNum = s.charAt(index) - '0';
            // 判断溢出情况
            if (result > (Integer.MAX_VALUE - currentNum) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + currentNum;
            index++;
        }
        return result * sign;
    }
}
