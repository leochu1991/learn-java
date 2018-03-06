package jianzhi_offer.fifty_four;

import java.lang.*;
import java.util.*;

//字符流中第一个不重复的字符
public class Solution {
    //occurrence[256]表示256个字符可能出现的次数
    int[] occurrence = new int[256];

    //初始化时赋值为-1，表示未出现过。Arrays.fill为静态方法，要放在代码块中；或者用for循环赋值-1
    {
        Arrays.fill(occurrence, -1);
    }

    //把index赋给每个字符只出现一次的字符，返回index最小的字符，即为第一个只出现一次的字符
    int index = 0;

    //Insert one char from stringstream
    public void Insert(char ch) {
        //i表示第i个字符，作为occurrence的索引
        int i = (int) ch;
        //occurrence[i]只出现一次，occurrence[i]等于index
        if (occurrence[i] == -1) {
            occurrence[i] = index;
        } else if (occurrence[i] >= 0) {
            // 否则occurrence[i]出现多次
            occurrence[i] = -2;
        }
        //计数
        index++;
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        //ch表示返回字符，初始值为'#'
        char ch = '#';
        //minIndex表示大于等于0的最小index，初始值为MAX_VALUE
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < occurrence.length; i++) {
            if (occurrence[i] >= 0 && occurrence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurrence[i];
            }
        }
        //返回第一个出现一次的字符，index最小
        return ch;
    }
}
