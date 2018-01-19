package md5util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 根据字符串生成相应的md5值，md5为单向哈希函数，输出固定长度的哈希值
 * 可以用 import org.apache.commons.codec.digest.DigestUtils;中的DigestUtils.md5Hex(str)来获得md5值
 */
public class MD5Util1 {
    // 转成小写md5
    private static char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    // 转成大写md5
    private static char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 产生md5值
     *
     * @param str
     * @param toLowerCase 是否小写字母输出
     * @return
     */
    private static String generateMD5(String str, boolean toLowerCase) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");
            // str生成信息摘要字节数组
            byte[] bytes = digest.digest(str.getBytes());
            // 返回hexString
            StringBuilder hexString = new StringBuilder();
            // 输出字母表
            char[] toDigits = toLowerCase ? DIGITS_LOWER : DIGITS_UPPER;
            for (byte b : bytes) {
                // 将每个字节(8 bit)转为正数，与0xff(255)取 &
                int temp = b & 0xff;
                // 将数据转换成16进制字符，一个字节有8bit，16进制用4bit表示一个字符，需要两个字符表示
                char high = toDigits[temp / 16];
                char low = toDigits[temp % 16];
                hexString.append(high).append(low);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        // 需要md5的字符串，按照orderid&username&paytypecode&key的顺序
        String strToSign = "20171210151655000008&yace1@test.com&sports_ticket&KGHabHFGHekgfl";
        // 代码生成的md5
        String srcSign = generateMD5(strToSign, true);
        // 网站生成的md5；https://md5jiami.51240.com/
        String destSign = "9177f63077879abb9c896dcb64122d90";
        System.out.println("代码生成的md5值: " + srcSign);
        System.out.println("网站生成的md5值: " + destSign + "\n二者是否相等? " + (srcSign.equals(destSign) ? "是" : "否"));
    }
}