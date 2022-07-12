package top.puppetdev.da.leetcode.editor.cn.data_structures.string;

import java.util.HashSet;

/**
 * 最长无重复字符子串
 * @author puppet
 * @since 2022/3/20 00:42
 */
public class LC3LongestSubstringWithoutRepeatingCharacters {
    /**
     * 散列表、滑动窗口
     * 什么是滑动窗口？就是一个队列
     * 比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。
     * 所以，我们要移动这个队列！
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public int solve(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int result = 0;
        // rp 为窗口的右边界指针
        int rp = 0;
        // i 为窗口的左边界指针，利用遍历来右移
        for (int i = 0; i < s.length(); i++) {
            // 如果右边界指针没有超出 s.length() 并且当前字符不重复，则将当前字符加入散列表中，并将右边界指针继续右移
            while (rp < s.length() && !hashSet.contains(s.charAt(rp))) {
                hashSet.add(s.charAt(rp));
                rp++;
            }
            result = Math.max(result, rp - i);
            // 当右边界指针移动至碰到重复字符时，则右移左边界指针，右移前，需要将当前左边界指针指向的字符从散列表中删除
            hashSet.remove(s.charAt(i));
        }
        return result;
    }
}
