package com.leyou.item.mapper;

import com.leyou.item.pojo.Spu;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author hhl
 * @date - 18:09
 */
public interface SpuMapper extends Mapper<Spu> {

    @Update("update tb_spu set saleable = 0 where id = #{spuId} ")
    void updateToLowerBySpuId(Long spuId);

    @Update("update tb_spu set saleable = 1 where id = #{spuId} ")
    void updateToUpperBySpuId(Long spuId);
}
