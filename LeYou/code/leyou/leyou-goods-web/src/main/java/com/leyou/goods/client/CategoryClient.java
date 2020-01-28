package com.leyou.goods.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hhl
 * @date - 22:39
 */
@FeignClient("item-service")
public interface CategoryClient extends CategoryApi {
}
