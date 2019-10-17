package com.env.common.constraint.mvc;

import com.env.common.constraint.Conditional;
import com.env.common.constraint.EnumConstraint;
import com.env.common.constraint.domain.BaseModel;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static com.env.common.constraint.mvc.ControllerConstraint.OrderType.ASC;
import static com.env.common.constraint.mvc.ControllerConstraint.SearchType.EQUALS;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/9 15:42
 */
public interface ControllerConstraint<T extends BaseModel> {

    @ApiOperation(value = "公共接口，根据id查询")
    @GetMapping("/{id}")
    T getById(@PathVariable("id") String id);

    @ApiOperation(value = "公共接口，分页查询")
    @GetMapping(value = "/{pageNum}/{pageSize}")
    PageInfo<T> list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize);

    @ApiOperation(value = "公共接口，搜索，支持 多字段查询、多字段排序、按时间搜索、分页")
    @PostMapping(value = "/search/{pageNum}/{pageSize}")
    PageInfo<T> search(@RequestBody(required = false) SearchConditional conditional, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize);

    @ApiOperation(value = "公共接口，创建")
    @PostMapping
    void insert(@Validated @RequestBody T bean);

    @ApiOperation(value = "公共接口，更新")
    @PutMapping
    void update(@Validated @RequestBody T bean);

    @ApiOperation(value = "公共接口，单个删除")
    @DeleteMapping(value = "/{id}")
    void deleteById(@PathVariable("id") String id);

    @ApiOperation(value = "公共接口，批量删除")
    @DeleteMapping
    void deleteById(@RequestBody List<String> id);

    @ApiModel("查询类型")
    enum SearchType implements EnumConstraint {
        @ApiModelProperty("精确查询")
        EQUALS("精确查询"),

        @ApiModelProperty("模糊查询")
        LIKE("模糊查询"),

        @ApiModelProperty("左边模糊查询")
        LIKE_LEFT("左边模糊查询"),

        @ApiModelProperty("右边模糊查询")
        LIKE_RIGHT("右边模糊查询"),
        ;

        private final String itemLabel;

        SearchType(String itemLabel) {
            this.itemLabel = itemLabel;
        }

        @Override
        public String enumItemLabel() {
            return this.itemLabel;
        }
    }

    @ApiModel("排序类型")
    enum OrderType implements EnumConstraint {
        @ApiModelProperty("正序")
        ASC("正序"),

        @ApiModelProperty("倒序")
        DESC("倒序"),
        ;

        private final String itemLabel;

        OrderType(String itemLabel) {
            this.itemLabel = itemLabel;
        }

        @Override
        public String enumItemLabel() {
            return this.itemLabel;
        }
    }

    @Data
    @ApiModel("搜索项")
    class SearchItem implements Serializable {
        @ApiModelProperty("字段名称")
        private String key;

        @ApiModelProperty("需要查询的字段值")
        private Object value;

        @ApiModelProperty("查询类型")
        private ControllerConstraint.SearchType searchType = EQUALS;
    }

    @Data
    @ApiModel("排序项")
    class OrderItem implements Serializable {
        private String key;

        private ControllerConstraint.OrderType orderType = ASC;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ApiModel("查询实体")
    class SearchConditional extends Conditional {
        private List<ControllerConstraint.SearchItem> searchItems;

        private List<ControllerConstraint.OrderItem> orderItems;
    }
}
