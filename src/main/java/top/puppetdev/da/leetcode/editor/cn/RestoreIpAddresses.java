package top.puppetdev.da.leetcode.editor.cn;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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
            backtrack(s, 4,new ArrayList<>());
            return res;
        }

        private void backtrack(String s, int step, List<String> tmp) {
            if (tmp.size() == 4 && tmp.stream().allMatch(item -> {
                int length = item.length();
                int value = Integer.parseInt(item);
                return (0 < length && length <= 3) && (length > 1 && item.charAt(0) != '0') && (0 <= value && value <= 255);
            })) {
                res.add(String.join(".", tmp));
                return;
            } else {
                // 其他情况说明不满足条件，剪枝
                return;
            }
            for (int i = 0; i < step; i++) {
                // if (visited[i]) continue;
                tmp.add()
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}