package com.example;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import java.util.Date;

@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        String traceId = RpcContext.getContext().getAttachment("traceId");

        System.err.println("traceId: " + traceId);

        String message = "Hello, " + name + ", " + new Date();
        if (traceId != null) {
            message += ", traceId: " + traceId;
        }

        return message;
    }
}
