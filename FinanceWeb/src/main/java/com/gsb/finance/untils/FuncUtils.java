package com.gsb.finance.untils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/8/9
 * Time: 11:56
 * Description：
 */
public class FuncUtils {

    /**
     * 设置下载文件中文件的名称
     *
     * @param fileName
     * @param request
     * @return
     */
    public static String encodeFilename(String fileName, HttpServletRequest request) {
        /**
         * 获取客户端浏览器和操作系统信息
         * 在IE浏览器中得到的是：User-Agent=Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; Alexa Toolbar)
         * 在Firefox中得到的是：User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.7.10) Gecko/20050717 Firefox/1.0.6
         */
        /*String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(fileName, "UTF-8");
                newFileName = StringUtils.replace(newFileName, "+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
                    newFileName = StringUtils.replace(newFileName, " ", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
                return MimeUtility.encodeText(fileName, "UTF-8", "B");

            return fileName;
        } catch (Exception ex) {
            return fileName;
        }*/
        String userAgent = request.getHeader("USER-AGENT");
        try {
            String finalFileName = null;
            if (StringUtils.contains(userAgent, "MSIE")) {//IE浏览器
                finalFileName = URLEncoder.encode(fileName, "UTF8");
            } else if (StringUtils.contains(userAgent, "Mozilla")) {//google,火狐浏览器
                finalFileName = new String(fileName.getBytes(), "ISO8859-1");
            } else {
                finalFileName = URLEncoder.encode(fileName, "UTF8");//其他浏览器
            }
            return finalFileName;
        } catch (UnsupportedEncodingException e) {
            return fileName;
        }
    }

    public Map diffList(List<String>list1,List<String>list2 ){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> diffmap = new HashMap<String, Object>();
        for (int i=0;i<list1.size();i++){
            map.put(list1.get(i),1);
        }
        for(int i=0;i<list2.size();i++){
           if(map.get(list2.get(i)) == null) {
               diffmap.put(list2.get(i),i);
           }
        }
        return diffmap;
    }
}
