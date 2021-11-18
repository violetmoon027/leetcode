//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。 
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。 
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。 
//
// 
//
// 示例 1： 
//
// 
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = A[0].length <= 20 
// 0 <= A[i][j] <= 1 
// 
// Related Topics 数组 双指针 矩阵 模拟 👍 264 👎 0

package leetcode.editor.cn;

//Java：翻转图像
public class FlippingAnImage {
    public static void main(String[] args) {
        Solution solution = new FlippingAnImage().new Solution();
        // TO TEST
        int[][] image = new int[][]{new int[]{1, 1, 0}, new int[]{1, 0, 1}, new int[]{0, 0, 0}};

        image = solution.flipAndInvertImage(image);
        for (int i = 0; i < image.length; i++) {
            for (int i1 = 0; i1 < image[i].length; i1++) {
                System.out.printf(image[i][i1] + " ");
            }
            System.out.println("-----------------------");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] flipAndInvertImage(int[][] image) {
            for (int i = 0; i < image.length; i++) {
                int i2 = image[i].length / 2;
                for (int i1 = 0; i1 < i2; i1++) {
                    image[i][i1] = image[i][i1] + image[i][image[i].length - i1 - 1];
                    image[i][image[i].length - i1 - 1] = image[i][i1] - image[i][image[i].length - i1 - 1];
                    image[i][i1] = image[i][i1] - image[i][image[i].length - i1 - 1];
                    image[i][i1] = ~image[i][i1] + 2;
                    image[i][image[i].length - i1 - 1] = ~image[i][image[i].length - i1 - 1] + 2;
                }
                if (image[i].length % 2 > 0) {
                    image[i][i2] = ~image[i][i2] + 2;
                }
            }
            return image;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}