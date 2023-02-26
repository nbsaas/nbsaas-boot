package com.nbsaas.boot.rest.annotations;


/**
 * 异常处理注解，通过aop处理一些不需要处理的异常
 */
public @interface ExceptionData {

    /**
     * 是非抛出异常
     *
     * @return
     */
    boolean throwException() default false;

}
