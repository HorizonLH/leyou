package com.leyou.search.pojo;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author hhl
 * @date - 20:28
 */
public class SearchResult extends PageResult<Goods> {

    private List<Map<String,Object>> categories;
    private List<Map<String,Object>> specs;
    private List<Brand> brands;

    public SearchResult() {
    }

    public SearchResult(List<Map<String, Object>> categories, List<Map<String, Object>> specs, List<Brand> brands) {
        this.categories = categories;
        this.specs = specs;
        this.brands = brands;
    }

    public SearchResult(Long total, List<Goods> items, List<Map<String, Object>> categories, List<Map<String, Object>> specs, List<Brand> brands) {
        super(total, items);
        this.categories = categories;
        this.specs = specs;
        this.brands = brands;
    }

    public SearchResult(Long total, Integer totalPage, List<Goods> items, List<Map<String, Object>> categories, List<Map<String, Object>> specs, List<Brand> brands) {
        super(total, totalPage, items);
        this.categories = categories;
        this.specs = specs;
        this.brands = brands;
    }

    public List<Map<String, Object>> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Map<String, Object>> specs) {
        this.specs = specs;
    }

    public List<Map<String, Object>> getCategories() {
        return categories;
    }

    public void setCategories(List<Map<String, Object>> categories) {
        this.categories = categories;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
}
