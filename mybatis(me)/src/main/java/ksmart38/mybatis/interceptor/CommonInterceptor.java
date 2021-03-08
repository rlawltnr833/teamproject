package ksmart38.mybatis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//클래스에 있는 기능들을 스캔
@Component
//HandlerInterceptor 상속 extends는 구버전
public class CommonInterceptor implements HandlerInterceptor{
	
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("CommonInterceptor ====================================== START");
		log.info("ACCESS INFO ====================================== START");
		log.info("PORT     		 :::::::::     {}", request.getLocalPort()); //포트번호
		log.info("serverName     :::::::::     {}", request.getServerName()); //도메인명
		log.info("method	     :::::::::     {}", request.getMethod()); //메서드 전송방식
		log.info("URI            :::::::::     {}", request.getRequestURI()); //URI
		log.info("ACCESS INFO ====================================== END");
		
		return HandlerInterceptor.super.preHandle(request, response, handler); // HandlerInterceptor.super.preHandle(request, response, handler) = true
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		log.info("CommonInterceptor ====================================== END");

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		log.info("CommonInterceptor ====================================== AFTER");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
