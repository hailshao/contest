package com.contest.common.util;

import java.util.UUID;

/**
 * @author zhangsan
 * @description UUID生成工具类
 * @date 2018年2月28日 下午8:35:30
 * @memo 无备注信息
 */
public class UUIDUtils {

    private final static int H2B_AB_10 = 'A' - 10;
    private final static int H2B_AL_10 = 'a' - 10;
    /**
     * 小写十六进制数组
     */
    private final static char[] LOWER_HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final String EMPTY_UUID_STR = "00000000-0000-0000-0000-000000000000";

    /**
     * 返回UUID(0,0)对应字符串：00000000-0000-0000-0000-000000000000
     *
     * @return
     */
    public static String emptyUuidStr() {
        return EMPTY_UUID_STR;
    }

    /**
     * 创建随机UUID对应的36位字符串
     *
     * @return
     */
    public static String newUuidStr() {
        return toString36(UUID.randomUUID());
    }

    /**
     * 判断uuidStr对应UUID对象是否为UUID(0,0)
     *
     * @param uuidStr
     * @return
     */
    public static boolean isEmpty(String uuidStr) {
        return StringUtils.isEmpty(uuidStr) || EMPTY_UUID_STR.equals(uuidStr);
    }

    /**
     * @param id
     * @return 返回带有中划线的36位字符串, 如： b007012b-767f-440d-95d3-fe69224e795d
     */
    public static String toString36(UUID id) {
        char[] charArray = new char[36];
        long least = id.getLeastSignificantBits();
        int index = 35;
        final int num1 = 15, num2 = 8;
        for (int i = num1; i >= num2; i--) {
            byte b = (byte) least;
            charArray[index--] = UUIDUtils.parseLowerChar(b & 0xf);
            charArray[index--] = UUIDUtils.parseLowerChar(b >>> 4 & 0xf);
            least >>>= 8;
            if (i == 10) {
                charArray[index--] = '-';
            }
        }
        charArray[index--] = '-';
        long most = id.getMostSignificantBits();
        final int num3 = 7;
        for (int i = num3; i >= 0; i--) {
            byte b = (byte) most;
            charArray[index--] = UUIDUtils.parseLowerChar(b & 0xf);
            charArray[index--] = UUIDUtils.parseLowerChar(b >>> 4 & 0xf);
            most >>>= 8;
            if (i == 6 || i == 4) {
                charArray[index--] = '-';
            }
        }
        return new String(charArray);
    }

    /**
     * 返回UUID，如果为空、字符串无效、转换发生异常则返回null
     *
     * @param id
     * @return
     */
    public static UUID fromString36(String id) {
        try {
            if (id == null || id.trim().length() == 0) {
                return null;
            }
            return parseUuidStr(id);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将十进制整数转为小写十六进制字符
     *
     * @param val 必须只能0-15的整数，调用处保证数据合法性，否则抛出异常
     * @return
     */
    private static char parseLowerChar(int val) {
        final int num1 = 15;
        if (val < 0 || val > num1) {
            throw new IllegalArgumentException("存在要转为十六进制字符的无效数值：" + val);
        }
        return UUIDUtils.LOWER_HEX_DIGITS[val];
    }

    private static int parseChar(String s, int offset) throws RuntimeException, StringIndexOutOfBoundsException {
        char c = s.charAt(offset);
        final char char0 = '0', char9 = '9', charA = 'A', charF = 'F', chara = 'a', charf = 'f';
        if (c < char0) {
        } else if (c <= char9) {
            return c - '0';
        } else if (c < charA) {
        } else if (c <= charF) {
            return c - H2B_AB_10;
        } else if (c < chara) {
        } else if (c <= charf) {
            return c - H2B_AL_10;
        }
        throw new RuntimeException("在偏移量" + offset + "处出现无效的十六进制字符'" + c + "'");
    }

    private static UUID parseUuidStr(String uuidStr) {
        long most = UUIDUtils.parseChar(uuidStr, 0);
        final int num1 = 8;
        for (int i = 1; i < num1; i++) {
            most = most << 4 | UUIDUtils.parseChar(uuidStr, i);
        }
        final int num2 = 9;
        final int num4 = 13;
        for (int i = num2; i < num4; i++) {
            most = most << 4 | UUIDUtils.parseChar(uuidStr, i);
        }
        final int num3 = 14, num5 = 18;
        for (int i = num3; i < num5; i++) {
            most = most << 4 | UUIDUtils.parseChar(uuidStr, i);
        }

        long least = UUIDUtils.parseChar(uuidStr, 19);
        final int num6 = 20, num7 = 23;
        for (int i = num6; i < num7; i++) {
            least = least << 4 | UUIDUtils.parseChar(uuidStr, i);
        }
        final int num8 = 24, num9 = 36;
        for (int i = num8; i < num9; i++) {
            least = least << 4 | UUIDUtils.parseChar(uuidStr, i);
        }
        return new UUID(most, least);
    }

}
