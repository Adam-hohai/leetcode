//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 257 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> st = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null){
            st.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()){
            res[i++] = st.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
