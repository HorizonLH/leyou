package cn.xawl.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hhl
 * @date - 18:53
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器的类型 ：pre post route error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序，返回值越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行run方法
     * true：执行run方法，false：不执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器的业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = context.getRequest();
        //获取参数
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)){
            //拦截
            context.setSendZuulResponse(false);//不转发请求
            //设置响应状态码，401身份未认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置相应的提示
            context.setResponseBody("request error!");
        }
        //代表返回值为null，代表该过滤器什么都不做
        return null;
    }
}
