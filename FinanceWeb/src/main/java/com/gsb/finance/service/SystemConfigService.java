package com.gsb.finance.service;


import com.gsb.finance.pojo.SystemConfigPojo;

import java.util.List;
import java.util.Map;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-05-24
 * @time 10:32
 * @description
 */
public interface SystemConfigService {
    List<SystemConfigPojo> getListByPage(SystemConfigPojo systemConfigPojo);

    int getTotalCount(SystemConfigPojo systemConfigPojo);

    int updateSystemConfig(SystemConfigPojo systemConfigPojo);

    int addSystemConfig(SystemConfigPojo systemConfigPojo);

    SystemConfigPojo getSystemConfigById(int id);

    int deleteSystemConfig(int id);

    SystemConfigPojo getSystemConfigByParamName(String paramName);

    Map<String,Object> getAllSystemConfig();
}
