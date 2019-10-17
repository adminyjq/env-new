package com.env.task.context.api.client;

import com.env.common.beans.core.ResponseBean;
import com.env.common.constraint.annotations.ClientController;
import com.env.task.client.ITaskTestClient;

@ClientController
public class TaskTestClient{


    public ResponseBean test01(String id, Integer num) {
        return null;
    }
}
