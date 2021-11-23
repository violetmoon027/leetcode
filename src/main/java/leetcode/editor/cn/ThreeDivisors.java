//给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。 
//
// 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：false
//解释：2 只有两个除数：1 和 2 。 
//
// 示例 2： 
//
// 输入：n = 4
//输出：true
//解释：4 有三个除数：1、2 和 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 数学 👍 10 👎 0

package leetcode.editor.cn;

//Java：三除数
public class ThreeDivisors {
    public static void main(String[] args) {
        Solution solution = new ThreeDivisors().new Solution();
        // TO TEST
        for (int i = 1; i < 100; i++) {
            System.out.println(i + "   " + solution.isThree(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] a = {4, 9, 25, 49, 121, 169, 289, 361, 529, 841, 961, 1369, 1681, 1849,
                2209, 2809, 3481, 3721, 4489, 5041, 5329, 6241, 6889, 7921, 9409};
        public boolean isThree(int n) {
            for (int i : a) {
                if (i == n) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}