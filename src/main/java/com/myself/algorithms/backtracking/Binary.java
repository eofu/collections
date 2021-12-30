package com.myself.algorithms.backtracking;

import java.util.Arrays;

public class Binary {
    public static void main(String[] args) {
        System.out.println(division(19, 4));

        System.out.println(addition("001", "001"));
    }

    /**
     * 问题：给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?231, 231?1]。本题中，如果除法结果溢出，则返回 231 ? 1
     */
    public static int division(int a, int b) {
        if (a == 0) {
            return 0;
        }

        boolean negative;
        negative = (a ^ b) < 0;
        int t = Math.abs(a);
        int d = Math.abs(b);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if (t >> i >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }

        return negative ? -result : result;
    }

    /**
     * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     */
    public static String addition(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int length = Math.min(aChar.length, bChar.length);
        char[] sumChar = new char[length + 1];
        boolean carryBit = false;
        for (int i = 0; i < length; i++) {
            if (aChar[i] == bChar[i] && aChar[i] == 1) {
                if (carryBit) {
                    sumChar[i] = '1';
                }
                sumChar[i] = '0';
                carryBit = true;
            } else {
                if (carryBit) {
                    sumChar[i] = '0';
                    carryBit = true;
                } else {
                    sumChar[i] = '1';
                    carryBit = false;
                }
            }

            if (i == length - 1) {
                if (carryBit) {
                    sumChar[length] = '1';
                }
            }
        }

        return Arrays.toString(sumChar).replaceAll(",", "");
    }
}
