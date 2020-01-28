package com.leyou.item.api;

import com.leyou.item.pojo.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hhl
 * @date - 22:50
 */
@RequestMapping("/category")
public interface CategoryApi {


    /**
     * 根据父节点的id查询子节点
     * @param pid
     * @return
     */
    @GetMapping("/list")
    public List<Category> queryCategoriesById(@RequestParam(value = "pid",defaultValue = "0") Long pid);
    /**
     *根据品牌信息查询商品分类
     * @param bid
     * @return
     */
    @GetMapping("bid/{bid}")
    public List<Category> queryBrandByBid(@PathVariable("bid") Long bid);

    /**
     * 根据分类id集合查询分类名称
     * @param ids
     * @return
     */
    @GetMapping
    public List<String> queryNamesByIds(@RequestParam("ids") List<Long> ids);

}
