package leetcode.editor.cn.data_structures.string;

/**
 * 最长公共前缀
 * @author puppet
 * @since 2022/3/27 21:08
 */
public class LC14LongestCommonPrefix {
    /**
     * 算法思想：无
     * 编程技巧：剪枝
     * 思路：
     * 先假设第一个字符串为最长的公共前缀 result，然后跟剩下的字符串进行两两对比，不断更新 result，
     * 如果 result 为 ""，则直接返回
     * 注意边界条件
     * <p>
     * 时间复杂度：O(s) —— s 为所有字符串的长度之和
     * 空间复杂度：O(1)
     * @param strs
     * @return
     */
    public static String solve(String[] strs) {
        // 根据题意：1 ≤ strs.length ≤ 200，故不需要考虑 strs.length 为 0 的情况
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 剪枝技巧：如果 result 为 ""，则直接返回
            if ("".equals(result)) return result;
            // 获取两个字符串的公共前缀，并用拿到的公共前缀来更新 result
            result = getCommonPrefix(result, strs[i]);
        }
        return result;
    }
    
    
    private static String getCommonPrefix(String result, String str) {
        int i = 0;
        // 当满足以下条件时，比较的字符持续后移
        while (i < result.length() && i < str.length() && result.charAt(i) == str.charAt(i)) {
            i++;
        }
        return result.substring(0, i);
    }
}
