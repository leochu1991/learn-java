package jianzhi_offer.forty_four;

//翻转单词顺序列
public class Solution {
    public String ReverseSentence1(String str) {
        //str长度为0或者为null，返回new String()
        if (str.length() == 0 || str == null) {
            return new String();
        }
        //res表示返回字符串，tmp表示处理的每段字符串
        String res = new String();
        String tmp = new String();

        for (int i = 0; i < str.length(); i++) {
            //str[i]==' '，将tmp字符串添加到res之前，并加上空格，tmp=""
            if (str.charAt(i) == ' ') {
                res = " " + tmp + res;
                tmp = "";
            } else {
                //否则将str[i]添加到tmp
                tmp += String.valueOf(str.charAt(i));
            }
        }
        //str最后一个字符不为＂＂时，将tmp添加到res之前
        if (tmp.length() > 0) {
            res = tmp + res;
        }
        //返回res
        return res;
    }

    public String ReverseSentence2(String str) {
        //str为null或者长度为0，返回new String()
        if (str == null || str.length() == 0) {
            return new String();
        }
        //将String str转换成字符数组char[] ch
        //先翻转整个字符串数组char[] ch
        char[] ch = str.toCharArray();
        int len = str.length();
        Reverse(ch, 0, len - 1);

        int begin = 0, end = 0;
        //再翻转每个单词，每个单词下标为[begin,end]，直到begin<len，即ch[len-1]
        while (begin < len) {
            //end<len防止越界；end不为' '，end++
            while (end < len && ch[end] != ' ') {
                end++;
            }
            //ch[end]=' '；翻转单词，下标为[begin,end-1]
            Reverse(ch, begin, end - 1);
            //end++：下一个不为' '的字符下标，即为下一个单词的开始下标
            end++;
            //下一个单词的begin
            begin = end;
        }
        //返回
        return new String(ch);
    }

    //翻转字符数组char[] ch
    public void Reverse(char[] ch, int begin, int end) {
        //交换从begin到end的字符数组ch
        while (begin < end) {
            char tmp = ch[begin];
            ch[begin] = ch[end];
            ch[end] = tmp;
            begin++;
            end--;
        }
    }
}
