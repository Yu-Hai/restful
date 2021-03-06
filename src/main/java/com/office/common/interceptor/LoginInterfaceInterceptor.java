package com.office.common.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.office.common.client.ResponseHandler;
import com.office.common.constants.ResponseCode;
import com.office.common.dto.UserDTO;
import com.office.common.session.SessionAttributeNames;
import com.office.common.util.PropertiesUtil;
/**
 * 登录认证的拦截器 
 * @author Neo
 *
 */
public class LoginInterfaceInterceptor extends HandlerInterceptorAdapter implements InitializingBean {
	private static Logger logger = Logger.getLogger(LoginInterfaceInterceptor.class);
	
	
	 /** 
     * Handler执行完成之后调用这个方法 
     */  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception exc)  
            throws Exception {  
    }  
  
    /** 
     * Handler执行之后，ModelAndView返回之前调用这个方法 
     */  
    public void postHandle(HttpServletRequest request, HttpServletResponse response,  
            Object handler, ModelAndView modelAndView) throws Exception {  
    }  

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		logger.trace("请求url：" + url);
		HttpSession session = request.getSession();
		logger.trace("SessionAttributeNames.CURRENT_USER:" + String.valueOf((session.getAttribute(SessionAttributeNames.CURRENT_USER) == null)));
		if (url.contains("/do/") || url.endsWith(".do")) {
			if(needLogin(request)){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("returnFlag", ResponseCode.SESSION_TIME_OUT);
				map.put("returnMsg", "未登录或者登录超时");
				ResponseHandler.writeContent(map, response);
				return false;
			}
		}

		return super.preHandle(request, response, handler);
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 * 判断是否需要登录
	 * @param request
	 * @return
	 */
	public boolean needLogin(HttpServletRequest request){
		String isNeedLogin=PropertiesUtil.getProperty("isNeedLogin");
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute(SessionAttributeNames.CURRENT_USER);
		logger.trace("SessionAttributeNames.CURRENT_USER:"+String.valueOf(request.getSession().getAttribute(SessionAttributeNames.CURRENT_USER)));
		if("true".equals(isNeedLogin)){
			if(userDTO==null){
				return true;
			}
			if(StringUtils.isNotBlank(userDTO.getIdUser())){
				return false;
			}
		}
		return true;
	}

}
