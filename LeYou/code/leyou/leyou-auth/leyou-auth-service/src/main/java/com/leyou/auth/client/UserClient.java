package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lh
 * @date 2019/12/26
 **/
@FeignClient("user-service")
public interface UserClient extends UserApi {
}
