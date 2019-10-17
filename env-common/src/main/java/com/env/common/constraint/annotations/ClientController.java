package com.env.common.constraint.annotations;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/10 14:52
 */
@RestController
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ClientController {
}
