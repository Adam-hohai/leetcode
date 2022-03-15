//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 240 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder stringBuilder = new StringBuilder(s);
        while (left < right) {
            if (characterList.contains(s.charAt(left)) && characterList.contains(s.charAt(right))) {
                char temp = s.charAt(left);
                stringBuilder.setCharAt(left, s.charAt(right));
                stringBuilder.setCharAt(right, temp);
                ++left;
                --right;
            } else if (characterList.contains(s.charAt(left)) && !characterList.contains(s.charAt(right))) {
                --right;
            } else if (!characterList.contains(s.charAt(left)) && characterList.contains(s.charAt(right))) {
                ++left;
            } else {
                ++left;
                --right;
            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
