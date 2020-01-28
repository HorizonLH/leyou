package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author hhl
 * @date - 13:10
 */
public interface BrandMapper extends Mapper<Brand> {

    @Insert("insert into tb_category_brand(category_id,brand_id) values (#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    @Select("select *from tb_category where id in(select category_id from tb_category_brand where brand_id = #{bid}) ")
    List<Category> selectCategoryByBid(Long bid);

    @Update("update tb_category_brand set category_id = #{cid} where brand_id = #{bid}")
    void updateCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 根据tb_category中的category_id查询满足条件brand_ud，再根据brand_id查询所有品牌
     * @param cid
     * @return
     */
    @Select("select *from tb_brand where id in (select brand_id from tb_category_brand where category_id = #{cid} )")
    List<Brand> selectBrandByCid(Long cid);
}
