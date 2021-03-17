package com.xiaodai.algorithm;

/**
 * Author ：dai
 * Date   ：2021/3/17 2:01 下午
 * Description：
 */
public class StringUtil {

    /**
     * 1、 判断两个字符串是否互为变形词
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isDeformation(String str1, String str2) {

        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        // 字符词频统计表
        int[] map = new int[256];

        // 对第一个字符串中的字符进行词频统计
        for (char c : chars1) {
            map[c]++;
        }

        // 用第二个字符串的字符去消除词频
        for (char c : chars2) {
            if (map[c]-- == 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * 2、 移除字符串中连续出现k个0的子串
     *
     * @param str
     * @param k
     * @return
     */
    public String removeKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                // 如果不等于'0'需要从start位置开始，去掉count个'0'字符
                if (count == k) {
                    while (count-- != 0) {
                        // ascii码空白字符的表示为十进制的0。chars[1] = 0 表示把1位置的字符，替换为空白符
                        chars[start++] = 0;
                    }
                }
                // 一轮剔除结束，count和start归位
                count = 0;
                start = -1;
            }
        }

        // 最后一轮，即如果字符串是以'0'字符结尾的。最后要单独结算一次
        if (count == k) {
            while (count-- != 0) {
                chars[start++] = 0;
            }
        }

        return String.valueOf(chars);
    }





    public static void main(String[] args) {

    }

}