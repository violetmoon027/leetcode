//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 826 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：Sqrt(x)
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        // TO TEST
        System.out.println(solution.mySqrt(7600));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            LinkedList<Integer> split = new LinkedList<>();
            split(split, x);
            int result = 0;
            int y = 0;
            int z = 0;
            Map<String, Integer> sqrt = new HashMap<>();
            while (!split.isEmpty()) {
                y = split.removeFirst() + y * 100;
                sqrt = getSqrt(y, result * 20, z);
                y = sqrt.get("remainder");
                result = result * 10 + sqrt.get("divisor");
            }
            return result;
        }

        /**
         * 1.分割数字
         *
         * @param split
         * @param x
         */
        public void split(LinkedList<Integer> split, int x) {
            split.addFirst(x % 100);
            x = x / 100;
            if (x >= 1) {
                split(split, x);
            }
        }

        /**
         * 基于y获取x的算术平方根
         *
         * @param x
         * @param y
         * @return
         */
        public Map<String, Integer> getSqrt(int x, int y, int z) {
            int i = y + z;
            int i1 = i * z;
            if (i1 <= x && x < (i + 1) * (z + 1)) {
                Map<String, Integer> result = new HashMap<>();
                result.put("remainder", x - i1);
                result.put("divisor", z);
                return result;
            } else {
                return getSqrt(x, y, z + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}