package cc.mikaka.mybatis.generator.plugin;

import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * JDBC类型和Java类型的转换对应关系
 * <p>
 * 可自定义数据库类型转化为Java的类型
 */
public class JavaTypeResolver extends JavaTypeResolverDefaultImpl {
    public JavaTypeResolver() {
        super();
        // super.typeMap.put(Types.TIMESTAMP, new JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(Timestamp.class.getName())));
        // super.typeMap.put(Types.TINYINT, new JdbcTypeInformation("INTEGER", new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
