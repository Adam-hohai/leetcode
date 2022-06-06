//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 1180 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; ++i){
            if (deque.isEmpty()) deque.push(temperatures[i]);
            else {
//                int peek = deque.peek();
//                deque.push(temperatures[i]);
                if (temperatures[i] > temperatures[index]){
                    int num = 1;
                    while (deque.size() != index + 1){
                        deque.pop();
                        ++num;
                    }
                    res[index] = num;
                    ++index;
                    i = i - num;
                }else {
                    deque.push(temperatures[i]);
                }
            }
            if (i == temperatures.length - 1){
                res[index++] = 0;
                i = index - 1;
            }
            System.out.println(Arrays.toString(res));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
