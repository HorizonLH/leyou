package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author hhl
 * @date - 22:47
 */

public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category,Long> {
}
