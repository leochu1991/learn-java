package md5util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 根据字符串生成相应的md5值，md5为单向哈希函数，输出固定长度的哈希值
 */
public class MD5Util {
    private static String generateMD5(String str) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");

            // 调用加密对象的方法，加密的动作已经完成
            byte[] bytes = digest.digest(str.getBytes());
            // 接下来，我们要对加密后的结果，进行优化，按照mysql的优化思路走
            // mysql的优化思路：
            // 第一步，将数据全部转换成正数：
            String hexString = "";
            for (byte b : bytes) {
                // 第一步，将数据全部转换成正数：
                // 解释：为什么采用b&255
                /*
                 * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                 * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                 * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                 * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                 * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                 */
                int temp = b & 255;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个"0"，变成"03"或者"0F"
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        // 需要md5的字符串，按照orderid&username&paytypecode&key的顺序
        String strToSign = "20171210151655000008&yace1@test.com&sports_ticket&KGHabHFGHekgfl";
        // 代码生成的md5
        String srcSign = generateMD5(strToSign);
        // 网站生成的md5；https://md5jiami.51240.com/
        String destSign = "9177f63077879abb9c896dcb64122d90";
        System.out.println("代码生成的md5值: " + srcSign);
        System.out.println("网站生成的md5值: " + destSign + "\n二者是否相等? " + (srcSign.equals(destSign) ? "是" : "否"));
    }
}