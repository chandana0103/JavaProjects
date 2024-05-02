package com.project.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoggingAspect {
//
//public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
//	
//	
//	//return type ,fully qualified class name,methodname,arguments
//
//	@Before("execution (* com.project.demo.service.JobService.*(..))")
//	public void logMethodCall() {
//		LOGGER.info("Method Called");
//	}
//	
//	@After("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
//	public void logMethodExecuted(JoinPoint jp) {
//		LOGGER.info("Method Executed "+jp.getSignature().getName());
//	}
//	
//	
//	@AfterThrowing("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
//	public void logMethodCrashed(JoinPoint jp) {
//		LOGGER.info("Method has some issues "+jp.getSignature().getName());
//	}
//	
//	
//	
//	@AfterReturning("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
//	public void logMethodExecutedSuccess(JoinPoint jp) {
//		LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
//	}
}
