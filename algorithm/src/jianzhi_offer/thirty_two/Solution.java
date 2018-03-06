package jianzhi_offer.thirty_two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 把数组排成最小的数
public class Solution {
    public String PrintMinNumber(int[] numbers) {
        //添加数组中元素到字符串数组中
        ArrayList<String> list = new ArrayList<>();
        for (int num : numbers)
            list.add(String.valueOf(num));
        //排序，实现Comparator接口以及compare方法
        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String s12 = s1 + s2;
                String s21 = s2 + s1;
                return s12.compareTo(s21);
            }
        });
        //将排序后的字符串连接起来
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i));
        return sb.toString();
    }
}
