//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2034 👎 0

package leetcode.editor.cn;

import com.sun.istack.internal.NotNull;

//Java：合并两个有序链表
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // TO TEST
        // 134  l1->l2->l3
        // 134  l4->l5->l6
        // 1==1 l1->l4->l5->l6 return l2->l3
        ListNode listNode = solution.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(ListNode.parseListNode(listNode));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }
            // 通过比较确认主树
            if (l1.val <= l2.val) {
                compare(l1, l1.next, l2);
                return l1;
            } else {
                compare(l2, l2.next, l1);
                return l2;
            }

        }

        public void compare(ListNode parent, ListNode listNode1, ListNode listNode2) {
            if (listNode1 == null) {
                parent.next = listNode2;
                return;
            }
            if (listNode1.val <= listNode2.val) {
                compare(listNode1, listNode1.next, listNode2);
            } else {
                parent.next = listNode2;
                compare(listNode2, listNode2.next, listNode1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//
//    public static int parseListNode(ListNode l1) {
//        ListNode temp = l1;
//        int level = 1, num1 = temp.val;
//        while ((temp = temp.next) != null) {
//            num1 += temp.val * Math.pow(10, level);
//            level++;
//        }
//        return num1;
//    }
//
//    public static ListNode parseNum(int num) {
//        // j最小值是1，所以当num值等于0的时候需要特殊处理
//        if (num == 0) {
//            return new ListNode(0);
//        }
//        int level = 0, i, j;
//        ListNode root = null, parent = null, node;
//        while ((j = (int) Math.pow(10, level)) > 0 && num - j >= 0) {
//            i = num / j % 10;
//            node = new ListNode(i);
//            if (level == 0) {
//                root = node;
//                parent = node;
//            } else {
//                parent.next = node;
//                parent = node;
//            }
//            level++;
//        }
//        return root;
//    }
//}