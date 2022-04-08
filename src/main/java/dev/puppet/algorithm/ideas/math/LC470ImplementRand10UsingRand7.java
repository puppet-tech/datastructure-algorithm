package dev.puppet.algorithm.ideas.math;

import java.util.Random;

/**
 * 用 Rand7() 实现 Rand10()
 * @author puppet
 * @since 2022/4/5 18:12
 */
public class LC470ImplementRand10UsingRand7 {
    /**
     * @Tag 数学
     * @Solution 拒接采样法
     *         根据题意，是要通过 Rand7() 实现 Rand10()，Rand7() 能等概率生成 1-7，Rand10() 要求等概率生成 1-10
     *         1. (rand7() - 1) * 7 能等概率生成 0、7、14、21、28、35、42
     *         2. (rand7() - 1) * 7 + rand7() 就能等概率生成 1、2、3、...、48、49
     *         3. 只使用前 40 个数字，大于 40 的重新生成随机数，即大于 40 的拒绝采样
     *         4. 此时，当生成 1、 11、21、31 时，则映射为 1
     *         当生成 2、12、22、32 时，则映射为 2。以此类推，则我们可以通过 result % 10 + 1 得到等概率生成的 1 - 10
     *         且这个概率为 4/49，但会有 9/49 的概率会被拒绝采样
     *         <p>
     *         9/49 拒绝采样的概率太大，我们可以进一步优化：
     *         1. 如果 (rand7() - 1) * 7 + rand7() > 40，不直接拒绝采样，而是 (rand7() - 1) * 7 + rand7() - 40 得到一个 rand9()
     *         2. (rand9() - 1) * 7 + rand7() 得到 rand63()
     *         3. 取 rand63() 前 60 个数字，然后 result % 10 + 1 就能得到等概率的 1-10
     *         此时被拒绝采样的概率为 4/49 * 3/63 = 12/3087，概率被大幅度降低。
     *         同理，还可以进一步优化，得到一个 rand21()，就不详细描述了。
     * @Tip 核心点：等概率！！！！
     * @TimeComplexity 最好时间复杂度为 O(1)，最坏时间复杂度为 O(∞)
     * @SpaceComplexity O(1)
     */
    public static int solve() {
        int result;
        do {
            result = (rand7() - 1) * 7 + rand7();
        } while (result > 40);
        return result % 10 + 1;
    }
    
    private static int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
