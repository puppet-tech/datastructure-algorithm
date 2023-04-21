package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：93 复原 IP 地址
 * @author puppet
 * @since 2023-03-14 22:37:55
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<String> res = new ArrayList<>();
        // private boolean[] visited;

        public List<String> restoreIpAddresses(String s) {
            // visited = new boolean[s.length()];
            backtrack(s, 0, new ArrayList<>());
            return res;
        }

        private void backtrack(String s, int ind, List<String> tmp) {
            if (tmp.size() > 4) return;
            if (ind == s.length() && tmp.size() == 4) {
                res.add(String.join(".", tmp));
                return;
            }
            for (int i = ind; i < Math.min(s.length(), ind + 3); i++) {
                String substring = s.substring(ind, i + 1);
                // 对拿到的子串进行判断，不符合的直接剪枝
                int length = substring.length();
                int value = Integer.parseInt(substring);
                if (value > 255 || (length > 1 && substring.charAt(0) == '0')) break;
                tmp.add(substring);
                backtrack(s, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}