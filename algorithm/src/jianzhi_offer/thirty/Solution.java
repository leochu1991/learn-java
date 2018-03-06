package jianzhi_offer.thirty;

//连续子数组的最大和
//动态规划
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        //array长度为0，返回0
        if (array.length == 0) {
            return 0;
        }
        //maxsum表示最大和，cursum表示当前和，当前和大于0，继续加下一个值，否则舍弃当前和
        int maxsum = array[0], cursum = array[0];

        for (int i = 1; i < array.length; i++) {
            //cursum>0,则cursum=cursum+array[i]，否则cursum=array[i]，重新计算cursum
            if (cursum > 0) {
                cursum = cursum + array[i];
            } else {
                cursum = array[i];
            }
            //将最大的cursum赋值给maxsum
            if (cursum > maxsum) {
                maxsum = cursum;
            }
        }
        //返回maxsum
        return maxsum;
    }
}
