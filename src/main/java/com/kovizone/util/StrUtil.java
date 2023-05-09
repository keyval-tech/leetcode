package com.kovizone.util;

/**
 * StrUtil
 *
 * @author KV
 * @since 2023/02/17
 */
public class StrUtil {

    /**
     * 模糊匹配
     * <p>
     * 可以理解为SQL的LIKE语法
     *
     * <p>
     * 例1：oriText:"abcd",keyword:"ab%" 结果：true
     * <p>
     * 例2：oriText:"abcd",keyword:"a%d" 结果：true
     * <p>
     * 例3：oriText:"abcd",keyword:"abcd" 结果：true
     * <p>
     * 例4：oriText:"abcd",keyword:"ab" 结果：false
     * <p>
     * 例5：oriText:"abcd",keyword:"ac%" 结果：false
     * <p>
     * 例5：oriText:"abcd",keyword:"a%c" 结果：false
     *
     * @param oriText     原文，如："abcd"
     * @param template 匹配关键词模板，如："ab%"
     * @return 匹配结果
     */
    public static boolean like(String oriText, String template) {
        return like(oriText, template, '%');
    }

    /**
     * 模糊匹配
     * <p>
     * 可以理解为SQL的LIKE语法
     *
     * <p>
     * 例1：oriText:"abcd",template:"ab%",matcher:'%' 结果：true
     * <p>
     * 例2：oriText:"abcd",template:"a%d",matcher:'%' 结果：true
     * <p>
     * 例3：oriText:"abcd",template:"abcd",matcher:'%' 结果：true
     * <p>
     * 例4：oriText:"abcd",template:"ab",matcher:'%' 结果：false
     * <p>
     * 例5：oriText:"abcd",template:"ac%",matcher:'%' 结果：false
     * <p>
     * 例5：oriText:"abcd",template:"a%c",matcher:'%' 结果：false
     *
     * @param oriText     原文，如："abcd"
     * @param template 匹配关键词模板，如："ab%"
     * @param matcher  模糊关键词（可以理解为SQL的LIKE语法的的'%'）
     * @return 匹配结果
     */
    public static boolean like(String oriText, String template, Character matcher) {
        if (oriText == null && template == null) {
            return true;
        }
        if (oriText == null || template == null) {
            return false;
        }
        oriText = oriText.trim();
        template = template.trim();
        String matcherStr = String.valueOf(matcher);
        if (!template.contains(matcherStr)) {
            return oriText.equals(template);
        }
        String[] split = template.trim().split(matcherStr);
        if (!template.startsWith(matcherStr) && !oriText.startsWith(split[0])) {
            return false;
        }
        if (!template.endsWith(matcherStr) && !oriText.endsWith(split[split.length - 1])) {
            return false;
        }
        int i = 0;
        int beginIndex = 0;
        while (beginIndex < oriText.length() && i < split.length) {
            String node = split[i];
            if (node != null) {
                int indexOfNode = oriText.indexOf(node);
                if (indexOfNode != -1) {
                    beginIndex = indexOfNode + node.length();
                } else {
                    return false;
                }
            }
            i++;
        }
        return i >= split.length;
    }
}
