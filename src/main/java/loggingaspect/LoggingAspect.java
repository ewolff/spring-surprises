package loggingaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

	@Around("execution (* logging.*.*(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Enter "+joinPoint.toShortString());
		try {
			return joinPoint.proceed();
		} catch (Throwable ex) {
			System.out.println("Exception "+ex);
			throw ex;
		} finally {
			System.out.println("Leave "+joinPoint.toShortString());	
		}
	}
}
