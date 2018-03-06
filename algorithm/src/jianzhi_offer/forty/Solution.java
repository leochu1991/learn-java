package jianzhi_offer.forty;

// 数组中只出现一次的数字

// num1,num2分别为长度为1的数组。传出参数
// 将num1[0],num2[0]设置为返回结果
// 异或的几个性质；1任何数和本身异或为0 2任何数和0异或是本身 3异或满足交换律
// 将一组数依次异或，因为交换律，最后得到只出现一次的数
// 若有两个只出现一次的数，一次异或整个数组得到flag，flag从右往左第一位为1为标准，将整个数组分为两组
// 再分别异或，每组数组中各有一个只出现一次的数
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //初始值为0
        num1[0] = 0;
        num2[0] = 0;
        //array为null或长度<2，返回
        if (array == null || array.length < 2) {
            return;
        }

        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            flag ^= array[i];
        }

        //以flag中从右往左第一位为1的位置为标准将数组元素分为两组，该位置上两个只出现一次的数不同，异或为1
        int pos = 0;
        while ((flag & 1) != 1) {
            flag = flag >> 1;
            pos++;
        }
        //array.length>=2   
        for (int i = 0; i < array.length; i++) {
            //数组中每个元素右移pos后&1，为1则分为一组，为0为另一组
            if (((array[i] >> pos) & 1) == 1) {
                //异或这组中的每个元素，将只出现一次的元素赋值给num1[0]
                num1[0] ^= array[i];
            } else {
                //同理
                num2[0] ^= array[i];
            }
        }
    }
}
