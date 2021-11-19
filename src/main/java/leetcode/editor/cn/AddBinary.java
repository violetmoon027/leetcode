//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 702 👎 0

package leetcode.editor.cn;

//Java：二进制求和
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        // TO TEST
        System.out.println(solution.addBinary("11", "1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            String bigStr = a.length() > b.length() ? a : b;
            b = a.length() > b.length() ? b : a;
            int bigIndex = bigStr.length() - 1;
            int smallIndex = b.length() - 1;
            boolean upgrade = false;
            StringBuffer sb = new StringBuffer("");
            while (smallIndex >= 0) {
                int i = b.charAt(smallIndex) + bigStr.charAt(bigIndex) + (upgrade ? 1 : 0);
                upgrade = i >= 98;
                smallIndex--;
                bigIndex--;
                sb.append(i % 2);
            }
            while (upgrade) {
                if (bigIndex >= 0) {
                    int i = bigStr.charAt(bigIndex) + 49;
                    upgrade = i >= 98;
                    sb.append(i % 2);
                    bigIndex--;
                } else {
                    sb.append(1);
                    upgrade = false;
                }
            }
            while (bigIndex >= 0) {
                sb.append(bigStr.charAt(bigIndex));
                bigIndex--;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}