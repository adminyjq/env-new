package com.env.common.constraint.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/24 22:52
 */
@Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FallbackComponent {
}
