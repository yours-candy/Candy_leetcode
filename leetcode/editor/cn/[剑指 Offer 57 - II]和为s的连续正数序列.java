//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 217 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_57_11 {
    /**  首先该题给出的是正序的连续序列
     * 滑动窗口法
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1; //滑动窗口的左边界
        int j = 1; //滑动窗口的右边界
        int sum = 0; //滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target/2){
            if (sum < target){
                //右边界向右移动
                sum += j;
                j++;
            }else if (sum > target){
                //左边界向右移动
                sum -= i;
                i++;
            }else {
                //记录结果
                // 若 相等，则：
                //  1、将当前区间数，当做一个结果，存储为数组
                //  2、将 目标数组，存入结果数组
                //  3、左边界 右移，查找 之后的结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                //左边界向右移动
                sum -= i; //左边界向右移动后需要减去移出滑动窗口的值
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
