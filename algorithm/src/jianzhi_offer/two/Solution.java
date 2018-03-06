package jianzhi_offer.two;

// 替换空格
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int i = 0;
        while (i < str.length()) {
            char index = str.charAt(i);
            if (index == ' ') {
                str.replace(i, i + 1, "%20");
                i = i + 3;
            } else {
                i++;
            }
        }
        return str.toString();
    }
}
