package leetcode.editor.cn.data_structures.string;

/**
 * 题目：468 验证IP地址
 * @author puppet
 * @since 2022-07-24 12:08:30
 */
public class ValidateIpAddress {
    public static void main(String[] args) {
        Solution solution = new ValidateIpAddress().new Solution();
        solution.validIPAddress("172.16.254.1");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 思路见题解
     * @TimeComplexity N
     * @SpaceComplexity 1
     * @Classification 字符串
     * @Tag 模拟、字符串
     */
    class Solution {
        private static final String ipv4 = "IPv4";
        private static final String ipv6 = "IPv6";
        private static final String invalid = "Neither";
        
        public String validIPAddress(String queryIP) {
            if (queryIP.length() == 0) return invalid;
            char head = queryIP.charAt(0);
            char tail = queryIP.charAt(queryIP.length() - 1);
            if (head == ':' || head == '.' || tail == '.' || tail == ':') return invalid;
            return queryIP.contains(".") ? validIPv4(queryIP) : validIPv6(queryIP);
        }
        
        private String validIPv4(String queryIP) {
            String[] split = queryIP.split("\\.");
            // check length
            if (split.length != 4) return invalid;
            // check every part
            for (String s : split) {
                int length = s.length();
                // 每个长度不在 1-3 之间
                if (length > 3 || length <= 0) return invalid;
                // 有前导 0，且长度不为 1
                if (s.charAt(0) == '0' && length != 1) return invalid;
                // 每个部分的值不在 0-255 之间
                int num = 0;
                for (int i = 0; i < length; i++) {
                    char c = s.charAt(i);
                    if (!Character.isDigit(c)) return invalid;
                    num = num * 10 + (c - '0');
                }
                if (num > 255) return invalid;
            }
            return ipv4;
        }
        
        private String validIPv6(String queryIP) {
            String[] split = queryIP.split(":");
            // 检查长度，需要被分为 8 个部分
            if (split.length != 8) return invalid;
            for (String s : split) {
                int length = s.length();
                // 如果每个部分的长度不在 0-4 之间
                if (length > 4 || length <= 0) return invalid;
                
                // 检查每个部分中的每个字符是否为 0-9、a-f、A-F
                for (int i = 0; i < length; i++) {
                    char c = s.charAt(i);
                    if (!(('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'))) return invalid;
                }
            }
            return ipv6;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}