package jianzhi_offer.thirty_three;

//丑数
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        //index<=0，返回0
        if (index <= 0) {
            return 0;
        }
        //array存放已经生成的丑数
        int[] array = new int[index];
        //i，j，k表示三个指针，先指向第一个丑数，当前的丑数应该是前面的每个丑数乘以2，3或者5的最小值（1除外）
        int i = 0;
        int j = 0;
        int k = 0;
        //第一个丑数为1
        array[0] = 1;
        int inx = 1;
        while (inx < index) {
            //当前丑数为之前丑数乘以2，3，5的最小值
            array[inx] = getMin(array[i] * 2, array[j] * 3, array[k] * 5);
            //若array[i]*2<=当前丑数，则说明array[i]*2已经出现在了丑数数组里，下一个丑数必须比array[inx]大，所以i++
            while (array[i] * 2 <= array[inx]) {
                i++;
            }
            //同理
            while (array[j] * 3 <= array[inx]) {
                j++;
            }
            //同理
            while (array[k] * 5 <= array[inx]) {
                k++;
            }
            //直到inx=index
            inx++;
        }
        //返回第index个丑数array[index-1]
        return array[index - 1];
    }

    //返回三个数中的最小值
    public int getMin(int i, int j, int k) {
        int tmp = i < j ? i : j;
        return tmp < k ? tmp : k;
    }
}
