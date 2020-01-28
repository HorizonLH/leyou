package com.leyou.item.api;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhl
 * @date - 13:11
 */
@RequestMapping("/brand")
public interface BrandApi {

    /**
     * 根据查询条件分页并排序查询品牌信息
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    @GetMapping("/page")
    public PageResult<Brand> queryBrandsByPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",required = false) Boolean desc

    );

    @PostMapping()
    public Void saveBrand(Brand brand , @RequestParam("cids")List<Long> cids);

    @PutMapping()
    public Void saveBrandUsingPut(Brand brand , @RequestParam("cids")List<Long> cids);

    @GetMapping("/cid/{cid}")
    public List<Brand> queryBrandByCid(@PathVariable("cid") Long cid);

    @GetMapping("{id}")
    public Brand queryBrandById(@PathVariable("id") Long id);






}
