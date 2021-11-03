# mybatis-generator-plugin

###实现SaaS模式下的适用于多租户情况的SQL自动生成
```java
<T> T selectByLogicIdAndTenantId(@Param("tenantId") String tenantId,@Param("logicId") String logicId);
int updateByPrimaryKeySelective(@Param("tenantId") String tenantId,@Param("logicId") String logicId);
```

### 示例：
1. 假设需要生成的表结构如下
```roomsql
CREATE TABLE `dict_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` varchar(64) NOT NULL COMMENT '租户ID',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `state` varchar(32) DEFAULT 'ONLINE' COMMENT '状态',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `detail_id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典明细表';
```
2. 在mybatis generator config文件中添加插件的配置
```xml
<plugin type="cc.mikaka.mybatis.generator.plugin.SelectByLogicIdAndTenantIdPlugin"/>
<plugin type="cc.mikaka.mybatis.generator.plugin.UpdateByLogicIdAndTenantIdSelectivePlugin"/>
```

3. 在mybatis generator config文件中添加表数据的配置
```xml
<table tableName="dict_detail">
    <property name="tableTenantId" value="tenant_id"/>
    <property name="tableLogicId" value="detail_id"/>
</table>
```

4. 其余配置根据需要变更，然后运行Main
