package com.gsb.finance.serviceImpl;

import com.gsb.finance.pojo.SystemConfigPojo;
import com.gsb.finance.service.SystemConfigService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-08-07
 * @time 16:31
 * @description
 */
@Service
public class SystemConfigServiceImpl implements SystemConfigService {
    @Override
    public List<SystemConfigPojo> getListByPage(SystemConfigPojo systemConfigPojo) {
        return null;
    }

    @Override
    public int getTotalCount(SystemConfigPojo systemConfigPojo) {
        return 0;
    }

    @Override
    public int updateSystemConfig(SystemConfigPojo systemConfigPojo) {
        return 0;
    }

    @Override
    public int addSystemConfig(SystemConfigPojo systemConfigPojo) {
        return 0;
    }

    @Override
    public SystemConfigPojo getSystemConfigById(int id) {
        return null;
    }

    @Override
    public int deleteSystemConfig(int id) {
        return 0;
    }

    @Override
    public SystemConfigPojo getSystemConfigByParamName(String paramName) {
        return null;
    }

    @Override
    public Map<String, Object> getAllSystemConfig() {
        return null;
    }
}
