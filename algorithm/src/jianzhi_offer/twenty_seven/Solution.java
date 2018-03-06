package jianzhi_offer.twenty_seven;

import java.util.*;

//字符串的排列
public class Solution {
    public ArrayList<String> Permutation(String str) {
        //返回res
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0)
            return res;
        //字符串结果去重
        HashSet<String> set = new HashSet<String>();
        char[] strs = str.toCharArray();
        //dfs求全排列
        dfs(strs, set, 0);
        //添加结果集
        res.addAll(set);
        //字典序排列
        Collections.sort(res);
        //返回res
        return res;
    }

    //递归，深度遍历
    private void dfs(char[] strs, HashSet<String> set, int index) {
        //index为最后一个字符时交换结束，将交换后的strs添加到set中
        if (index == strs.length - 1) {
            set.add(new String(strs));
        } else {
            //交换第一个字符和剩下的字符
            for (int i = index; i < strs.length; i++) {
                //交换index和第i个字符
                swap(strs, index, i);
                //将剩下的字符串进行dfs
                dfs(strs, set, index + 1);
                //将字符串恢复到交换之前的状态，便于下一次for循环进行交换
                swap(strs, index, i);
            }
        }
    }

    //交换strs中index和i位置上的字符
    private void swap(char[] strs, int index, int i) {
        if (index != i) {
            char tmp = strs[index];
            strs[index] = strs[i];
            strs[i] = tmp;
        }
    }
}
