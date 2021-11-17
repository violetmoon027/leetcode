//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1866 👎 0

package leetcode.editor.cn;

//Java：最长公共前缀
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // TO TEST

        System.out.println(solution.longestCommonPrefix(new String[]{"asd", "as"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            char prefix = '0';
            for (int i = 0; i < strs[0].length(); i++) {
                prefix = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() <= i) {
                        return strs[0].substring(0, i);
                    }
                    if (prefix != strs[j].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
                if (i == strs[0].length() - 1) {
                    return strs[0];
                }
            }
            return "";
        }
//leetcode submit region end(Prohibit modification and deletion)
    }
}