package com.env.common.constraint.mvc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.env.common.constraint.domain.BaseModel;
import com.env.common.exceptions.BaseException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

import static com.env.common.constraint.domain.BaseModel.CREATE_TIME_DB_FIELD;
import static com.env.common.constraint.mvc.ControllerConstraint.OrderType.ASC;
import static com.env.common.constraint.mvc.ControllerConstraint.OrderType.DESC;
import static com.env.common.constraint.mvc.ControllerConstraint.SearchType.*;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/10 9:06
 */
@Slf4j
public abstract class ControllerConstraintImpl<T extends BaseModel> implements ControllerConstraint<T> {

    protected abstract ServiceConstraint<T> getService();

    public T getById(@PathVariable("id") String id) {
        if (Objects.isNull(id)) {
            throw new BaseException("id 不能为空");
        }

        return getService().getById(id);
    }

    public PageInfo<T> list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        Page<T> page = PageHelper.startPage(pageNum, pageSize);

        List<T> data = getService().list();

        PageInfo<T> result = page.toPageInfo();
        result.setList(data);

        return result;
    }

    public PageInfo<T> search(@RequestBody(required = false) SearchConditional conditional, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        Page<T> page = PageHelper.startPage(pageNum, pageSize);

        QueryWrapper<T> queryWrapper = new QueryWrapper<>();

        if (CollectionUtils.isNotEmpty(conditional.getSearchItems())) {
            for (ControllerConstraint.SearchItem searchItem : conditional.getSearchItems()) {
                if (EQUALS.equals(searchItem.getSearchType())) {
                    queryWrapper.eq(searchItem.getKey(), searchItem.getValue());
                } else if (LIKE.equals(searchItem.getSearchType())) {
                    queryWrapper.like(searchItem.getKey(), searchItem.getValue());
                } else if (LIKE_LEFT.equals(searchItem.getSearchType())) {
                    queryWrapper.likeLeft(searchItem.getKey(), searchItem.getValue());
                } else if (LIKE_RIGHT.equals(searchItem.getSearchType())) {
                    queryWrapper.likeRight(searchItem.getKey(), searchItem.getValue());
                }
            }
        }

        if (CollectionUtils.isNotEmpty(conditional.getOrderItems())) {
            for (ControllerConstraint.OrderItem orderItem : conditional.getOrderItems()) {
                if (ASC.equals(orderItem.getOrderType())) {
                    queryWrapper.orderByAsc(orderItem.getKey());
                } else if (DESC.equals(orderItem.getOrderType())) {
                    queryWrapper.orderByDesc(orderItem.getKey());
                }
            }
        }

        if (Objects.nonNull(conditional.getStartTime())) {
            queryWrapper.ge(CREATE_TIME_DB_FIELD, conditional.getStartTime());
        }

        if (Objects.nonNull(conditional.getEndTime())) {
            queryWrapper.lt(CREATE_TIME_DB_FIELD, conditional.getEndTime());
        }

        getService().list(queryWrapper);

        return new PageInfo<>(page);
    }

    public void insert(@Validated @RequestBody T bean) {
        if (!getService().save(bean)) {
            throw new BaseException("保存失败");
        }
    }

    public void update(@Validated @RequestBody T bean) {
        if (!getService().updateById(bean)) {
            throw new BaseException("更新失败");
        }
    }

    public void deleteById(@PathVariable("id") String id) {
        if (!getService().removeById(id)) {
            throw new BaseException("删除失败");
        }
    }

    public void deleteById(@RequestBody List<String> id) {
        if (!getService().removeByIds(id)) {
            throw new BaseException("删除失败");
        }
    }

}
