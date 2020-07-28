package com.dp.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dp.springcloud.entities.CommonResult;
import com.dp.springcloud.entities.Payment;

/**
 * @author dp
 * @data 2020/7/26 - 23:20
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult (4444,"按客户自定义,global1111111111111111",new Payment (2020L,"serial003"));
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult (4444,"按客户自定义,global22222222222222",new Payment (2020L,"serial003"));
    }

}
