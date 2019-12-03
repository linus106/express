package com.linus.express.order.aop;

import com.linus.express.order.bean.OrderQueryCondition;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author wangxiangyu
 * @Date 2019/12/3 10:39
 * @Description TODO
 */
@Aspect
@Component
public class OrderQueryParamAdaptAspect {

    @Pointcut("@annotation(com.linus.express.order.annotation.Adapt)")
    public void pointCut(){};


    @Before(value = "pointCut()")
    public void adpationParam(JoinPoint joinPoint) {
        Object arg = joinPoint.getArgs()[0];
        if (arg instanceof OrderQueryCondition) {
            OrderQueryCondition condition = (OrderQueryCondition)arg;
            condition.adaptEmptyFields();
        }
    }
}
