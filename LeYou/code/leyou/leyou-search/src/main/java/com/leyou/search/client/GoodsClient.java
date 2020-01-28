package com.leyou.search.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * @author hhl
 * @date - 22:21
 */
@FeignClient(value = "item-service")
public interface GoodsClient extends GoodsApi {
}
