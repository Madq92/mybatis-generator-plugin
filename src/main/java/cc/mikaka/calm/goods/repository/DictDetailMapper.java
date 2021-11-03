package cc.mikaka.calm.goods.repository;

import cc.mikaka.calm.goods.entity.DictDetail;
import cc.mikaka.calm.goods.entity.DictDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:41:58 CST 2021
     */
    long countByExample(DictDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:41:58 CST 2021
     */
    int deleteByExample(DictDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:41:58 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:41:58 CST 2021
     */
    int insert(DictDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:41:58 CST 2021
     */
    int insertSelective(DictDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:41:58 CST 2021
     */
    List<DictDetail> selectByExample(DictDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:41:58 CST 2021
     */
    DictDetail selectByLogicIdAndTenantId(@Param("tenantId") String tenantId, @Param("detailId") String detailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:42:01 CST 2021
     */
    int updateByExampleSelective(@Param("record") DictDetail record, @Param("example") DictDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:42:01 CST 2021
     */
    int updateByExample(@Param("record") DictDetail record, @Param("example") DictDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:42:01 CST 2021
     */
    int updateByPrimaryKeySelective(@Param("tenantId") String tenantId, @Param("detailId") String detailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dict_detail
     *
     * @mbg.generated Wed Nov 03 13:42:02 CST 2021
     */
    int updateByPrimaryKey(DictDetail record);
}