package com.msr.algorithm.offer;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/21 15:18
 * @version: v1.0
 */

public class ReplaceBlank {

    public static void main(String[] args) {
        ReplaceBlank replaceBlank = new ReplaceBlank();
        String s ="hello world string!";
        String spaces = replaceBlank.replaceSpaces(new StringBuffer(s));
        System.out.println(spaces);
    }

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。
     *
     * 你可以假定输入字符串的长度最大是1000。
     * 注意输出字符串的长度可能大于1000。
     */
    public String replaceSpaces(StringBuffer raw){
        char[] charArray = raw.toString().toCharArray();
        StringBuffer result = new StringBuffer();
        for (char c : charArray) {
            if (c == ' ') {
                result.append("%20");
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
