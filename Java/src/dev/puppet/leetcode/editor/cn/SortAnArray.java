//<p>给你一个整数数组&nbsp;<code>nums</code>，请你将该数组升序排列。</p>
//
//<p>&nbsp;</p>
//
//<ol>
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,2,3,1]
//<strong>输出：</strong>[1,2,3,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,1,1,2,0,0]
//<strong>输出：</strong>[0,0,1,1,2,5]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
//	<li><code>-5 * 10<sup>4</sup> &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>桶排序</li><li>计数排序</li><li>基数排序</li><li>排序</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 551</li><li>👎 0</li></div>

package dev.puppet.leetcode.editor.cn;

import org.omg.CORBA.RepositoryIdHelper;

import java.util.PrimitiveIterator;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @Tag 排序算法、快排
         * @Solution
         * @TimeComplexity O(NlogN)
         * @SpaceComplexity O(n)
         */
        public int[] sortArray(int[] nums) {
            if (nums.length <= 1) return nums;
            int start = 0;
            int end = nums.length - 1;
            process(nums, start, end);
            return nums;
        }
        
        private void process(int[] nums, int start, int end) {
            if (start >= end) return;
            
            int pivot = nums[start];
            int left = start, right = end;
            while (left < right) {
                while (left < right) {
                    if (nums[right] < pivot) {
                        nums[left] = nums[right];
                        break;
                    }
                    right--;
                }
                while (left < right) {
                    if (nums[left] > pivot) {
                        nums[right] = nums[left];
                        break;
                    }
                    left++;
                }
            }
            // 注意需要将位置填回去
            nums[left] = pivot;
            process(nums, start, left - 1);
            process(nums, left + 1, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}