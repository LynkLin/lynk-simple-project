package com.lynk.system.start;

import com.lynk.system.task.SysTaskManager;
import com.lynk.system.tool.SequenceManager;
import com.lynk.system.tool.SysErrorCodeManager;
import com.lynk.system.tool.SysParamManager;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Lynk
 */
@Component
public class AppInit implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppInit.class);

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... strings) throws Exception {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("============start init system============");
        }
        SysParamManager.getInstance().init();
        SysErrorCodeManager.getInstance().init();
        SysTaskManager.getInstance().init(scheduler);
        SequenceManager.getInstance().init();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("============init system end============");
        }
    }
}
