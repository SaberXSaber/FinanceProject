package com.gsb.finance.untils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/7/26
 * Time: 14:24
 * Description：
 */
public class GetFundTask {
    public static JSONObject httpPost(String url,JSONObject jsonParam){
        return httpPost(url, jsonParam, false);
    }

    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            org.apache.http.HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    /**把json字符串转换成json对象**/
                   // jsonResult = JSONObject.fromObject(str);
                    jsonResult =JSONObject.parseObject(str);
                } catch (Exception e) {
                    System.out.println("post请求提交失败:" + url);
                }
            }
        } catch (IOException e) {
//            logger.error("post请求提交失败:" + url, e);
            System.out.println("post请求提交失败:" + url);
        }
        return jsonResult;
    }


    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static JSONObject httpGet(String url,int fundType){
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            org.apache.http.HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == 200) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
               // jsonResult = JSONObject.fromObject(strResult);
//                jsonResult =JSONObject.parseObject(strResult);
//                url = URLDecoder.decode(url, "UTF-8");

                parseJson(strResult,fundType);


            } else {
//                logger.error("get请求提交失败:" + url);
                System.out.println("get请求提交失败:" + url);
            }
        } catch (IOException e) {
//            logger.error("get请求提交失败:" + url, e);
            System.out.println("get请求提交失败:" + url);
        }
        return jsonResult;
    }

    public static void parseJson(String str ,int fundType){
        String json_str=str.split("=")[1];
        JSONObject jsonResult =JSONObject.parseObject(json_str);
//        System.out.println(jsonResult.get("datas"));
        List<List<Object>> listA= (List<List<Object>>) jsonResult.get("datas");
        try {
            db(listA,fundType);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }



       /* System.out.println(listA.size());
        System.out.println(listA.get(2));
        List<Object> listB=  listA.get(2);

        System.out.println(listB.get(0));
        System.out.println(listB.get(1));

        System.out.println(listB.get(7));
        System.out.println(listB.get(8));
        System.out.println(listB.get(9));
        System.out.println(listB.get(10));
        System.out.println(listB.get(17));

        for (int i=0;i<listB.size();i++){
            System.out.println(i+"  : "+listB.get(i));
        }*/

    }
    public static String strsql(List<Object> list){
        java.util.Date date =new java.util.Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String baseurl="http://fund.eastmoney.com/";
        String str ="INSERT INTO fund (fundCode,fundName,detailedUrl,dailyValue,dailyRate,applyState,redeemState,poundage,createTime) " +
                "VALUES("+list.get(0)+","+list.get(1)+",'"+baseurl+list.get(0)+".html"+"',"+list.get(7)+","+list.get(8)+","+list.get(9)+","+
                list.get(10)+","+list.get(17)+",'"+dateFormater.format(date)+"');";
        return str;

    }


    public static void db(List<List<Object>> listA,int fundType) throws SQLException {
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "root";

        PreparedStatement pstmt;


        java.util.Date date =new java.util.Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String baseurl="http://fund.eastmoney.com/";
        String sql = "insert into fund (fundCode,fundName,detailedUrl,dailyValue,dailyRate,applyState,redeemState,poundage,createTime,fundType) values(?,?,?,?,?,?,?,?,?,?)";

        try {
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if(!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句

            pstmt = (PreparedStatement) con.prepareStatement(sql);



            for (List<Object> list:listA){
                String dailyValue="0.0";
                if(StringUtils.isNotBlank(list.get(7).toString())){
                    dailyValue=list.get(7).toString();
                }
                String dailyRate="0.0";
                if(StringUtils.isNotBlank(list.get(8).toString())){
                    dailyRate=list.get(8).toString();
                }

                pstmt.setString(1, list.get(0).toString());
                pstmt.setString(2, list.get(1).toString());
                pstmt.setString(3, baseurl+list.get(0)+".html");
                pstmt.setString(4, dailyValue);
                pstmt.setString(5, dailyRate);
                pstmt.setString(6, list.get(9).toString());
                pstmt.setString(7, list.get(10).toString());
                pstmt.setString(8, list.get(17).toString());
                pstmt.setString(9, dateFormater.format(date));
                pstmt.setString(10,String.valueOf(fundType));
                System.out.println(pstmt.toString());

                try{
                    int i = pstmt.executeUpdate();
                }catch (Exception e){
                    System.out.println(list.get(0).toString()+"  "+list.get(1).toString());
                }

            }

            /*String sql ="";
            for (List<Object> list:listA){
                sql =strsql(list);
                System.out.println(sql);
                ResultSet rs = statement.executeQuery(sql);
            }*/

           /* String sql = "select * from emp";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);*/
            pstmt.close();
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static void main(String[] args) {
       /* List<Object> listB= new ArrayList<Object>();
        for (int i=0;i<3;i++){
            List<String> listA= new ArrayList<String>();
            listA.add(i+"a");
            listA.add(i+"b");
            listA.add(i+"c");
            listB.add(listA);
        }

        System.out.println(listB);*/

        int fundType =2;
        //股票型基金
        String url="http://fund.eastmoney.com/Data/Fund_JJJZ_Data.aspx?t=1&lx="+fundType+"&letter=&gsid=&text=&sort=zdf,desc&page=1,5000&dt=1500969535491&atfc=&onlySale=0";
        httpGet(url,fundType);


        //混合型基金
        fundType =3;
        url="http://fund.eastmoney.com/Data/Fund_JJJZ_Data.aspx?t=1&lx="+fundType+"&letter=&gsid=&text=&sort=zdf,desc&page=1,5000&dt=1500969535491&atfc=&onlySale=0";
        httpGet(url,fundType);

    }
}
