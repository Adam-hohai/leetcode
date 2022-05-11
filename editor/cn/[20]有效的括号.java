//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3239 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c== '[' || c == '{'){
                deque.push(c);
            }else {
                if (deque.isEmpty()) return false;
                char c_pop = deque.pop();
//                System.out.println(c_pop);
//                System.out.println(c);
                if (c_pop == '(' && c != ')') return false;
                if (c_pop == '[' && c != ']') {
                    System.out.println('1');
                    return false;
                }
                if (c_pop == '{' && c != '}') return false;
            }
        }
//        System.out.println('1');
        return deque.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
