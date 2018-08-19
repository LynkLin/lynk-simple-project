package com.lynk.system.tool;

import com.lynk.system.entity.SysParam;
import com.lynk.system.service.ISysParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lynk on 2016/12/29.
 */
public class SysParamManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysParamManager.class);

    private ISysParamService sysParamServiceImpl;

    private static SysParamManager sysParamManager;
    private static Map<String, String> sysParam = new HashMap<>();

    public static SysParamManager getInstance() {
        if (sysParamManager == null) {
            sysParamManager = new SysParamManager();
        }
        return sysParamManager;
    }

    private SysParamManager() {
    }

    public void init() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("start load system param");
        }
        sysParamServiceImpl = AppManager.getBean("sysParamServiceImpl", ISysParamService.class);
        List<SysParam> params = sysParamServiceImpl.selectList(null);
        for (SysParam param: params) {
            sysParam.put(getRealKey(param.getCategory(), param.getCode()), param.getValue());
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("load system cache finish");
        }

    }

    public String getParam(String category, String key) {
        return sysParam.get(getRealKey(category, key));
    }

    public Integer getIntParam(String category, String key) {
        try {
            return Integer.parseInt(getParam(category, key));
        } catch (Exception e) {
            return 0;
        }
    }

    private String getRealKey(String category, String key) {
        return category + "." + key;
    }
}
