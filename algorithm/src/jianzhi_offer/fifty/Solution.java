package jianzhi_offer.fifty;

// 数组中重复的数字
public class Solution {
    // Parameters:
    // numbers: an array of integers
    // length:  the length of array numbers
    // duplication:(Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    // Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    // 这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:true if the input is valid, and there are some duplications in the array number
    // otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        //n个数字，值在0~n-1之间，一次遍历，时间复杂度O(n)
        //将numbers[i]作为索引
        for (int i = 0; i < length; i++) {
            //index为索引
            int index = numbers[i];
            //索引大于等于长度length，减去长度或者取模
            index = index % length;
            //numbers[i]即index若出现两次，则numbers[index]>=length
            if (numbers[index] >= length) {
                //将出现两次的数字index赋给duplication[0]，返回true
                duplication[0] = index;
                return true;
            }
            //否则numbers[index]+length作为标记，表示出现一次
            numbers[index] = numbers[index] + length;
        }
        //否则返回false
        return false;
    }
}
