package cn.tedu.sp11.filter;

import cn.tedu.web.util.JsonResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
        //前置过滤器中已经存在5个默认的过滤器，其中第五个过滤器，向上下文对象添加了serviceid这个属性
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
        //获得request对象
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //用request接收token参数
        String token = request.getParameter("token");
        //（模拟登陆）如果token参数为空，没有登录不允许访问,返回登陆提示
        if(StringUtils.isBlank(token)){
            ctx.setSendZuulResponse(false);  //阻止继续访问
            ctx.setResponseStatusCode(JsonResult.NOT_LOGIN);
            ctx.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).msg("Not log in").toString());
        }
        return null;  //当前zuul版本中，返回值没吊用
    }
}
