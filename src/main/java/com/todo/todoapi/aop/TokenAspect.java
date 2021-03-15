package com.todo.todoapi.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.todo.todoapi.common.service.TokenService;

@Component
@Aspect
public class TokenAspect {
	@Autowired
	private TokenService tokenService;

	@Around("todoControllers()")
	public Object validateToken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		Get http request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		
		try {
//			Get token from header
			String tokenId = request.getHeader("AuthorizedToken");
			
//			Validating the token
			String tokenData = tokenService.validateTokenAndGetData(tokenId);
			
			System.out.println("Authorized Token Data : " + tokenData);
		} catch (Exception e) {
//			If token is not valid send the Invalid token response
			return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
		}
		
//		If token is valid then proceed to the controllers
		return proceedingJoinPoint.proceed();
	}
	
	@Pointcut("execution(* com.todo.todoapi.controllers.TodoController.*(..))")
	public void todoControllers() {
	}
	
}
