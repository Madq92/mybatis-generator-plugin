package cc.mikaka.mybatis.generator.plugin;

import cc.mikaka.mybatis.generator.util.Assert;
import cc.mikaka.mybatis.generator.util.StringUtil;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

import static cc.mikaka.mybatis.generator.common.Constants.LOGIC_TABLE_ID;
import static cc.mikaka.mybatis.generator.common.Constants.TABLE_TENANT_ID;

/**
 * updateByLogicIdAndTenantIdSelective方法生成
 * <p>
 * 在updateByPrimaryKeySelective方法位置替换
 */
public class UpdateByLogicIdAndTenantIdSelectivePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method,
                                                                    Interface interfaze,
                                                                    IntrospectedTable introspectedTable) {
        String tableTenantId = (String) introspectedTable.getTableConfiguration().getProperties().get(TABLE_TENANT_ID);
        cc.mikaka.mybatis.generator.util.Assert.notNull(tableTenantId, TABLE_TENANT_ID + " is null");
        //添加租户ID
        String fieldTenantId = StringUtil.convertCamel(tableTenantId);
        FullyQualifiedJavaType tenantIdJavaType = introspectedTable.getColumn(tableTenantId).getFullyQualifiedJavaType();
        Parameter tenantIdParameter = new Parameter(tenantIdJavaType, fieldTenantId);
        tenantIdParameter.addAnnotation("@Param(\"" + fieldTenantId + "\")");
        method.addParameter(tenantIdParameter);

        //添加逻辑ID
        String tableLogicId = (String) introspectedTable.getTableConfiguration().getProperties().get(LOGIC_TABLE_ID);
        if (null == tableLogicId) {
            Parameter parameter = method.getParameters().get(0);
            if (parameter.getAnnotations().size() == 0) {
                parameter.addAnnotation("@Param(\"" + parameter.getName() + "\")");
            }
            return true;
        }
        method.getParameters().remove(0);

        String fieldLogicId = StringUtil.convertCamel(tableLogicId);

        FullyQualifiedJavaType logicIdJavaType = introspectedTable.getColumn(tableLogicId).getFullyQualifiedJavaType();
        Parameter logicIdParameter = new Parameter(logicIdJavaType, fieldLogicId);
        logicIdParameter.addAnnotation("@Param(\"" + fieldLogicId + "\")");
        method.addParameter(logicIdParameter);
        return true;
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {
        String tableTenantId = (String) introspectedTable.getTableConfiguration().getProperties().get(TABLE_TENANT_ID);
        Assert.notNull(tableTenantId, TABLE_TENANT_ID + " is null");

        TextElement oldWhereCondition =
                (TextElement) element.getElements().stream().filter(ele -> (ele instanceof TextElement) && ((TextElement) ele).getContent().contains(
                        "where")).findFirst().get();
        element.getElements().remove(oldWhereCondition);

        String whereCondition = "";
        String tableLogicId = (String) introspectedTable.getTableConfiguration().getProperties().get(LOGIC_TABLE_ID);
        if (null == tableLogicId) {
            whereCondition = oldWhereCondition.getContent();
        } else {
            //替换逻辑ID
            String fieldLogicId = StringUtil.convertCamel(tableLogicId);
            String logicIdJdbcType = introspectedTable.getColumn(tableLogicId).getJdbcTypeName();
            whereCondition = "where " + tableLogicId + " = #{" + fieldLogicId + ",jdbcType=" + logicIdJdbcType + "}";
        }

        //添加租户ID
        String tenantIdJdbcType = introspectedTable.getColumn(tableTenantId).getJdbcTypeName();
        String fieldTenantId = StringUtil.convertCamel(tableTenantId);

        whereCondition = whereCondition + " and " + tableTenantId + " = " + "#{" + fieldTenantId + "," + "jdbcType=" + tenantIdJdbcType + "}";

        element.getElements().add(new TextElement(whereCondition));
        return true;
    }
}
