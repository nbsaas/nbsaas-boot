package com.nbsaas.boot.rest.api;

import java.util.function.Function;

/**
 * 数据转换接口
 *
 * @param <R> 结果类
 * @param <S> 需要转换的类
 * @author ada
 */
public interface Converter<R, S> extends Function<S, R> {
    R convert(S source);

    default R apply(S s) {
        return convert(s);
    }
}
