package cc.mikaka.mybatis.generator.util;

public class StringUtil {
    public static String convertCamel(String underline) {
        if (null == underline || underline.length() == 0) {
            return underline;
        }
        int len = underline.length();
        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {

            char c = underline.charAt(i);
            if (c == '_' && (++i) < len) {
                c = underline.charAt(i);
                stringBuilder.append(Character.toUpperCase(c));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
