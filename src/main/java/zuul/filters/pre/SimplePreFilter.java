package zuul.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class SimplePreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getRemoteAddr());
        if(!request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")){
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("access denied");
            ctx.setSendZuulResponse(false);

        }
        return null;
    }
}
