package com.env.common.constants;

import com.env.common.constraint.EnumConstraint;
import lombok.Getter;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 10:04
 */
public class Constants {

    public static final class ResponseKey {

        /**
         * 响应状态码 Key
         */
        public static final String CODE_KEY = "code";

        /**
         * 响应数据 Key
         */
        public static final String DATA_KEY = "data";

        /**
         * 响应消息 Key
         */
        public static final String MESSAGE_KEY = "message";

    }

    public enum ResponseStatus implements EnumConstraint {
        SUCCESS(200, "success"),
        ERROR(500, "error");

        @Getter
        private String message;
        @Getter
        private Integer statusCode;

        ResponseStatus(Integer statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        @Override
        public Integer enumItemOrdinal() {
            return getStatusCode();
        }

        @Override
        public String enumItemLabel() {
            return getMessage();
        }

    }

}
