package com.leyou.cart.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lh
 * @date 2019/12/27
 **/
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
