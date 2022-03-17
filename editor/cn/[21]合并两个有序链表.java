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
// Related Topics 递归 链表 👍 2272 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) return list2;
        else if (list1 != null && list2 == null) return list1;
        else if (list1 == null && list2 == null) return null;
        ListNode dummy1 = new ListNode(-1, list1);
        ListNode dummy2 = new ListNode(-101, list2);
        while (dummy1.next != null){
            ListNode cur2 = dummy2;
            ListNode cur1 = dummy1.next;
            dummy1.next = cur1.next;
            while (cur2 != null){
                if (cur1.val >= cur2.val && cur1.val <= (cur2.next == null ? 101 : cur2.next.val)){
                    cur1.next = cur2.next;
                    cur2.next = cur1;
                    break;
                }
                cur2 = cur2.next;
            }
        }
        return dummy2.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
