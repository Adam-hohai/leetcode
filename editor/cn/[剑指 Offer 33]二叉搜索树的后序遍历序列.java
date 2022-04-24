//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        if (n == 0) return true;
        return verify(postorder, 0, n - 1);
    }

    private boolean verify(int[] postorder, int p1, int p2){
        if (p1 >= p2) return true;
        int pos = p1;
        while (pos < p2 && postorder[pos] < postorder[p2]) ++pos;
        int p = pos;
        while (pos < p2){
            if (postorder[pos] < postorder[p2]) return false;
            ++pos;
        }
        return verify(postorder, p1, p - 1) && verify(postorder, p, p2 - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
