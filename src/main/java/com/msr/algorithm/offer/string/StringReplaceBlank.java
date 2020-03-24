package com.msr.algorithm.offer.string;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/21 15:18
 * @version: v1.0
 */

public class StringReplaceBlank {

    public static void main(String[] args) {
        StringReplaceBlank stringReplaceBlank = new StringReplaceBlank();
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello world string!");
        String spaces = stringReplaceBlank.replaceSpaces(buffer);
        System.out.println(spaces);
        String s = stringReplaceBlank.replaceV2(buffer);
        System.out.println(s);
    }

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。
     * <p>
     * 你可以假定输入字符串的长度最大是1000。
     * 注意输出字符串的长度可能大于1000。
     */
    public String replaceSpaces(StringBuffer raw) {
        char[] charArray = raw.toString().toCharArray();
        StringBuffer result = new StringBuffer();
        for (char c : charArray) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * 使用正则
     *
     * @param raw
     * @return
     */
    public String replaceV2(StringBuffer raw) {
        return raw.toString().replaceAll("\\s", "%20");
    }
}
