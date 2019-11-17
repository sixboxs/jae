package test.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.filter.bean.UserInfoBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter
public class FirstFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(FirstFilter.class);

    private static String LOGIN_KEY = "login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("{} init...", FirstFilter.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("{} start", FirstFilter.class);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String requestUrl = request.getRequestURI();
        logger.info("remoteAddr-->{}, remoteHost-->{}, requestUrl-->{}", remoteAddr, remoteHost, requestUrl);
        HttpSession session = request.getSession();
        UserInfoBean userInfoBean;
        if (session.getAttribute(LOGIN_KEY)==null){
            userInfoBean = new UserInfoBean();
            userInfoBean.setIp(remoteAddr);
            userInfoBean.setCount(0);
            session.setAttribute(LOGIN_KEY, userInfoBean);
        }else {
            userInfoBean = (UserInfoBean) session.getAttribute(LOGIN_KEY);
            userInfoBean.setCount(userInfoBean.getCount() + 1);
            session.setAttribute(LOGIN_KEY, userInfoBean);
        }
        response.addCookie(new Cookie(LOGIN_KEY, userInfoBean.toString()));
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("{} end", FirstFilter.class);
    }

    @Override
    public void destroy() {
        logger.info("{} destroy...", FirstFilter.class);
    }
}
