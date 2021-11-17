//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 231 👎 0

package leetcode.editor.cn;

//Java：不用加减乘除做加法
public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
        // TO TEST
        solution.add(-9, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            int sum = 0;
            int carry = 0;
            do {
                sum = a ^ b;
                carry = (a & b) << 1;
                a = sum;
                b = carry;
            } while (b != 0);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}