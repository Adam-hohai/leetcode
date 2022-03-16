//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 👍 833 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode left = head;
        ListNode right = head.next;
        while (right != null){
            if (left.val == right.val){
//                System.out.println(left.val);
//                System.out.println(right.val);
                set.add(left.val);
            }
            left = right;
            right = right.next;
        }

        while (set.contains(head.val)){
            head = head.next;
            if (head == null) return null;
        }

        left = head;
        right = head.next;
        while (right != null){
            if (set.contains(right.val)){
                left.next = right.next;
                right = left.next;
            }else {
                left = right;
                right = right.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
