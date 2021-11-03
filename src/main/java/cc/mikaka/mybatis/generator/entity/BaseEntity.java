package cc.mikaka.mybatis.generator.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    /**
     * 状态
     */
    private String state;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;
}
