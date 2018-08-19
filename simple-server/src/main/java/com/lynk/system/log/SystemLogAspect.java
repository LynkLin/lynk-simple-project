package com.lynk.system.log;

import com.lynk.system.common.Constants;
import com.lynk.system.common.JsonBuilder;
import com.lynk.system.log.annotation.SystemLog;
import com.lynk.system.tool.SequenceManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Lynk
 * @since 2018/01/11
 */
@Aspect
@Component
@Order(Constants.ASPECT_ORDER_LOG)
public class SystemLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemLogAspect.class);

    private ThreadLocal<String> ids = new ThreadLocal<>();



    @Before("@annotation(com.lynk.system.log.annotation.SystemLog) && @annotation(systemLog)")
    public  void doBefore(JoinPoint joinPoint, SystemLog systemLog) {
        String id = SequenceManager.getInstance().nextSequenceId();

        ids.set(id);

        LOGGER.info("[{}][###### START ######] {}, {}", id, systemLog.description(), joinPoint.getTarget().getClass().getName());

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            LOGGER.info("[{}][入参{}, {}]: {}", id, i + 1, arg.getClass().getName(), JsonBuilder.builder(true).bean2Json(arg));
        }
    }

    @AfterReturning(pointcut = "@annotation(com.lynk.system.log.annotation.SystemLog)", returning = "resp")
    public void afterReturning(Object resp) {
        LOGGER.info("[{}][出参]: {}", ids.get(), JsonBuilder.builder(true).bean2Json(resp));
        LOGGER.info("[{}][###### END ######]", ids.get());
        ids.remove();
    }
}
