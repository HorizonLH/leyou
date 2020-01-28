package com.leyou.item.api;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhl
 * @date - 18:10
 */
public interface GoodsApi {

    /**
     * 根据条件类分页查询spu
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/spu/page")
    public PageResult<SpuBo> querySpuByPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "saleable",required = false) Boolean saleable,
            @RequestParam(value = "page",defaultValue = "1",required = false) Integer page,
            @RequestParam(value = "rows",defaultValue = "5",required = false) Integer rows
    );

    /**
     * 查询spuDetails
     * @param spuId
     * @return
     */
    @GetMapping("spu/detail/{spuId}")
    public SpuDetail querySpuDetailBySpuId(@PathVariable("spuId")Long spuId);

    /**
     * 查询sku
     * @param spuId
     * @return
     */
    @GetMapping("sku/list")
    public List<Sku> querySkusBySpuId(@RequestParam("id")Long spuId);

    @PutMapping("goods")
    public Void updateGoods(@RequestBody SpuBo spuBo);

    @PostMapping("/goods")
    public Void saveGoods(@RequestBody SpuBo spuBo);


    @GetMapping("lower/{spuId}")
    public Void lowerGoods(@PathVariable("spuId") Long spuId);

    @GetMapping("upper/{spuId}")
    public Void upperGoods(@PathVariable("spuId") Long spuId);

    @GetMapping("{id}")
    public Spu querySpuById(@PathVariable("id") Long id);

    @GetMapping("sku/{skuId}")
    public Sku querySkuBySkuId(@PathVariable("skuId")Long skuId);

}
