package org.demo.config;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@LogMethodInvocation  // Bind this interceptor to the LogMethodInvocation annotation
public class LoggingInterceptor {

    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {
        // before method execution
        System.out.println("Before method: " + context.getMethod().getName());

        // Proceeding with method invocation
        Object result = context.proceed();

        // after method execution
        System.out.println("After method: " + context.getMethod().getName());

        return result;
    }
}
