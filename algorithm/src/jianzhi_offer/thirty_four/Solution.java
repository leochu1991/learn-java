package jianzhi_offer.thirty_four;

import java.util.*;

//第一个只出现一次的字符
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        //LinkedHashMap添加元素时包含顺序，依次将所有字符及当前出现次数添加到hash中，键不重复，所以次数超过1时会覆盖原有值
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
        //初始时设inx为-1，当str为null或者str没有只出现一次的字符时返回
        int inx = -1;
        //添加hashmap，str的每个字符key及当前出现的次数value作为键值对添加
        for (int i = 0; i < str.length(); i++) {
            //若hash包含字符，则count+1
            if (hash.containsKey(str.charAt(i))) {
                int count = hash.get(str.charAt(i));
                hash.put(str.charAt(i), count + 1);
            }
            //否则value值为1
            else {
                hash.put(str.charAt(i), 1);
            }
        }
        //找到第一次key为1的inx，break
        //i<str.length(),不是hash.size(),hash.size()<=str.length(),hashmap中键唯一
        for (int i = 0; i < str.length(); i++) {
            if (hash.get(str.charAt(i)) == 1) {
                inx = i;
                break;
            }
        }
        //返回inx，未找到则inx=-1
        return inx;
    }
}
