//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为无重复元素的升序排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1170 👎 0

package leetcode.editor.cn;

//Java：搜索插入位置
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        // TO TEST
        int[] nums = {1, 3};
        System.out.println(solution.searchInsert(nums, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (target <= nums[0]) {
                return 0;
            } else if (nums[nums.length - 1] < target) {
                return nums.length;
            }
            // [1,3,5,6], 2
            int start = 0, end = nums.length - 1, split = end / 2;
            while (split != end) {
                if (nums[split] <= target && target <= nums[split + 1]) {
                    if (nums[split] == target) {
                        end = split;
                    } else {
                        end = split = split + 1;
                    }
                } else if (target < nums[split]) {
                    end = split;
                    split = split - end / 2;
                } else {
                    start = split;
                    split = start + (end - start) / 2;
                }
            }
            return start != split ? end : start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}