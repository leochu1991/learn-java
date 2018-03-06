package jianzhi_offer.twenty_eight;

import java.util.HashMap;

//数组中出现次数超过一半的数字
public class Solution {
    // hashmap
    public int MoreThanHalfNum_Solution1(int[] array) {
        //若不存在输出0
        int result = 0;
        //hashmap存放每个数字出现的次数
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            //hash中若存在array[i]，次数+1
            if (hash.containsKey(array[i]))
                hash.put(array[i], hash.get(array[i]) + 1);
                //否则次数为1
            else
                hash.put(array[i], 1);
            //出现次数大于数组长度的一半，result=array[i]
            if (hash.get(array[i]) > array.length / 2)
                result = array[i];
        }

        return result;
    }

    // 打擂台算法；阵地攻守
    public int MoreThanHalfNum_Solution2(int[] array) {
        //不存在或者数组为null，输出0
        int result = 0;
        if (array.length == 0) {
            return result;
        }

        int x = array[0];
        int times = 1;
        //找出出现次数最多的数x，x在数组中出现次数可能比times多，需要另外遍历
        for (int i = 1; i < array.length; i++) {
            //相等，times++
            if (x == array[i]) {
                times++;
            }//否则times--
            else {
                times--;
            }
            //若times==0，x重新赋值，times=1
            //times=0，表示x出现的次数小于等于数组长度的一半，丢弃当前值，重新赋值
            if (times == 0) {
                x = array[i];
                times = 1;
            }
        }
        //遍历数组查看x出现次数
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                times++;
            }
        }
        //超过一半，输出
        if (times > array.length / 2) {
            result = x;
        }
        return result;
    }
}
