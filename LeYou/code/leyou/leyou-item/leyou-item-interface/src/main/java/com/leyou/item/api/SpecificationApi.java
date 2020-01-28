package com.leyou.item.api;

import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhl
 * @date - 16:52
 */
@RequestMapping("/spec")
public interface SpecificationApi {




    /**
     * 根据分类id查询参数组
     * @param cid
     * @return
     */
    @GetMapping("/groups/{cid}")
    public List<SpecGroup> querySpecGroupsByCid(@PathVariable("cid") Long cid);

    /**
     * 根据具体的参数查询所需规格参数
     * @param gid
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    @GetMapping("params")
    public List<SpecParam> queryParams(
            @RequestParam(value = "gid",required = false) Long gid,
            @RequestParam(value = "cid",required = false) Long cid,
            @RequestParam(value = "generic",required = false) Boolean generic,
            @RequestParam(value = "searching",required = false) Boolean searching

    );

    @PostMapping("goods")
    public Void saveGoods(@RequestBody SpuBo spuBo);

    @GetMapping("group/param/{cid}")
    public List<SpecGroup> queryGroupsWithParam(@PathVariable("cid") Long cid);


}
