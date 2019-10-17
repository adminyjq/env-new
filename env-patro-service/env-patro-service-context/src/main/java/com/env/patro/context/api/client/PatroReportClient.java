package com.env.patro.context.api.client;

import com.env.common.constraint.annotations.ClientController;
import com.env.patro.client.IPatroReportClient;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 17:34
 */
@ClientController
public class PatroReportClient implements IPatroReportClient {


    @Override
    public List<Integer> generateList(Integer max, Integer min) {
        if (Objects.isNull(min)) {
            min = 1;
        }

        if (max < min) {
            return Collections.singletonList(max);
        }

        List<Integer> data = new LinkedList<>();

        for (int i = min; i < max; i++) {
            data.add(i);
        }

        return data;
    }




}
