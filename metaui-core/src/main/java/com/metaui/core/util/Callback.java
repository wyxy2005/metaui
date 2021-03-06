package com.metaui.core.util;

/**
 * @author wei_jc
 * @since 1.0.0
 */
public interface Callback<T, R> {
    R call(T t, Object... obj) throws Exception;
}
