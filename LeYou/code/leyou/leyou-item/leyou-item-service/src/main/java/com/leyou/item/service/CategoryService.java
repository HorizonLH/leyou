package com.leyou.item.service;

import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hhl
 * @date - 22:50
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    public List<Category> ResponseEntity(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return this.categoryMapper.select(record);
    }

    public List<Category> queryBrandByBid(Long bid) {
        //Brand brand = this.brandMapper.selectByPrimaryKey(bid);
        return this.brandMapper.selectCategoryByBid(bid);
    }
    public List<String> queryNameByIds(List<Long> ids){
        List<Category> categories = this.categoryMapper.selectByIdList(ids);
        return categories.stream().map(category ->  category.getName()).collect(Collectors.toList());
    }
}
