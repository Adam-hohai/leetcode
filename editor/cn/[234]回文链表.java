//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1319 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0, right = 0;
        if (list.size() % 2 == 0){
            right = list.size() / 2;
            left = right - 1;
        }else {
            right = list.size() / 2 + 1;
            left = list.size() / 2 - 1;
        }
//        System.out.println(left);
//        System.out.println(right);
        while (left >= 0 && right < list.size()){
            if (!Objects.equals(list.get(left), list.get(right))){
                return false;
            }
            --left;
            ++right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
