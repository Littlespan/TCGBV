package cn.tedu.sp11.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/10/30 11:55
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Component
public class AccessFukter extends ZuulFilter {
    //过滤器类型：pre,routes,post,error
    @Override
    public String filterType() {
//        return "pre";
        return FilterConstants.PRE_TYPE;
    }

    //当前过滤器添加到哪个位置，返回一个顺序号
    @Override
    public int filterOrder() {
        //该过滤器顺序要 > 5，才能得到 serviceid
//        return 6;
        return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
    }

    //针对当前请求进行判断，是否执行过滤代码（run方法）
    @Override
    public boolean shouldFilter() {
        //当前请求，调用的是否是 item-service
        //如果请求 item，执行过滤代码
        //否则跳过过滤代码

        //获得正在调用的服务Id
        RequestContext ctx = RequestContext.getCurrentContext(); //zuul请求上下文对象
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);//从上下文对象，获取“服务id”属性的值
        //如果调用的是"Item-service",则调用过滤代码
        return "item-service".equalsIgnoreCase(serviceId);
    }


    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
