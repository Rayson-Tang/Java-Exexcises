package com.Rayson.algorithm.kmp;

public class KMP {
    public static void main(String[] args) {
        String s1 = "bbcabcdab abcdabcdabde";
        String s2 = "abcdabd";
        int[] next = kmpNext(s2);
        int kmp = kmp(s1, s2, next);
        System.out.println(kmp);
    }

    //kmp算法
    public static int kmp(String s1, String s2, int[] next) {
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取子串的部分匹配值
    public static int[] kmpNext(String dest) {
        int next[] = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
