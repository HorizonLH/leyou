package com.leyou.goods.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hhl
 * @date - 22:38
 */
@FeignClient("item-service")
public interface SpecificationClient extends SpecificationApi {
}
