package cc.mikaka.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 用户注解生成
 * <p>
 * Override对应的方法可修改对应地方的注解
 */
public class CustomCommentGenerator extends DefaultCommentGenerator {

    private boolean suppressAllComments;

    public CustomCommentGenerator() {
        super();
        suppressAllComments = false;
    }

    /**
     * do 实体注解
     *
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder();
        sb.append(" * " + introspectedColumn.getActualColumnName());

        String remarks = introspectedColumn.getRemarks();
        if (null != remarks && remarks.length() != 0)
            sb.append('-' + remarks);

        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }
}