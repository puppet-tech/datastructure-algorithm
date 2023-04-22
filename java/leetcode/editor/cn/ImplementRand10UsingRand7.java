package top.puppetdev.da.leetcode.editor.cn;

/**
 * 题目：470 用 Rand7() 实现 Rand10()
 * @author puppet
 * @since 2023-04-21 16:24:53
 */
public class ImplementRand10UsingRand7{
    public static void main(String[] args) {
        Solution solution = new ImplementRand10UsingRand7().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int ans;
        do {
            ans = (rand7() - 1) * 7 + rand7();
        } while (ans > 40);
        return ans % 10 + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}