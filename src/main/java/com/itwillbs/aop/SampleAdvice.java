package com.itwillbs.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {

  @Before("execution(* com.itwillbs.service.BoardService*.*(..))")
  public void startLog() {
	  System.out.println("----------------------------");
	  System.out.println("----------------------------");
  }

}
