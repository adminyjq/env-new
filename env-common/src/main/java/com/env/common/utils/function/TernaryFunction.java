package com.env.common.utils.function;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/05/08 13:34
 */
@FunctionalInterface
public interface TernaryFunction<T, U, I, R> {
    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @param i the third function argument
     * @return the function result
     */
    R apply(T t, U u, I i);
}
