package com.gsb.finance.startup;

import com.gsb.finance.service.SystemConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gsb
 * @version V1.0.0
 * @date 2018-05-24
 * @time 16:42
 * @description 启动程序  加载系统配置参数
 */
@Component
public class DictionariesHelper {
//    private static final Logger log = LoggerFactory.getLogger(DictionariesHelper.class);
    private static Map<String,Object> dataMap = new HashMap<String,Object>();
    private static DictionariesHelper dictionariesHelper;

    //service组件
    private static SystemConfigService systemConfigServiceImpl;
    /*@Autowired(required = true)
    public static void setSystemConfigServiceImpl(SystemConfigService systemConfigServiceImpl) {
        DictionariesHelper.systemConfigServiceImpl = systemConfigServiceImpl;
    }*/

    public DictionariesHelper() {
    }

    public static DictionariesHelper getInstance(SystemConfigService systemConfigServiceImpl){
        if(DictionariesHelper.dictionariesHelper==null){
            DictionariesHelper.dictionariesHelper = new DictionariesHelper();
        }
        DictionariesHelper.systemConfigServiceImpl =systemConfigServiceImpl;
        return DictionariesHelper.dictionariesHelper;
    }

    /**
     * 初始化数据字典
     */
    public void init(){
        if(DictionariesHelper.dataMap.size()==0){
            initDataDictionaries();
        }
    }
    /**
     * 重载数据字典
     */
    public static   void reLoad() {
        // TODO Auto-generated method stub
        DictionariesHelper.dataMap.clear();
        if(DictionariesHelper.dataMap.size()==0){
            initDataDictionaries();
        }
    }


    /**
     * 初始化数据字典
     */
    private static void initDataDictionaries(){
//        log.info("--------------数据字典初始化开始---------------");
        //获取系统当前时间
        Long startTime = System.currentTimeMillis();
        dataMap = systemConfigServiceImpl.getAllSystemConfig();
//        log.info("--------------数据字典完成初始化,共用时"+(System.currentTimeMillis()-startTime)+"ms---------------");
    }

    /**
     * 获取所有字典数据
     */
    public static Map<String,Object> getDataDictionaries(){
        return DictionariesHelper.dataMap;
    }


    /**
     * 根据key获取value
     * @param key
     * @return 值
     */
    public static Object getDicValueByCode(String key){
        return DictionariesHelper.dataMap.get(key);
    }
}
