package com.gsb.finance.untils;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2015/12/29
 * Time: 11:02
 * Description：导出excel工具父类
 */
public abstract class AbstractReportExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filename = this.getFileName(map.get("fileName").toString(),request);
//        String title = this.getTitle();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        HSSFSheet excelSheet = hssfWorkbook.createSheet();
        excelSheet.setDefaultColumnWidth(18);


        // 合并单元格
     /*   Region region = new Region(0, (short) 0, 0, (short) 4);
        excelSheet.addMergedRegion(region);
*/
        // 设置表头样式
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        // 字体居中显示
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置边框
        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderRight((short) 1);
        style.setBorderTop((short) 1);

        HSSFFont font = hssfWorkbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);


        // 获取列名
//        List<String> columns = this.getColumnNames();
        List<String> columns = this.getColumnNames((List<String>)map.get("columns"));
        if (columns != null) {
            // 创建一行
    /*        HSSFRow excelTitle = excelSheet.createRow(0);
            // 创建一列.
            HSSFCell cellTitle = excelTitle.createCell(0);
            cellTitle.setCellStyle(style);
            cellTitle.setCellValue(title);
            excelTitle.setHeight((short) 400);*/
            HSSFRow excelHeader = excelSheet.createRow(0);
            HSSFCell cellHeader = null;
            excelHeader.setHeight((short) 400);
            for (int i = 0; i < columns.size(); i++) {
                // 设置列样式
                cellHeader = excelHeader.createCell(i);
                cellHeader.setCellStyle(style);
                // 设置列名
                cellHeader.setCellValue(columns.get(i));
                // 设置列宽
                excelSheet.setColumnWidth(i, 20 * 256);
            }
        }
        int record = 1;
//        List<Object> reportList = (List<Object>) map.get("resultList");
        List<Object[]> list = this.getColumnDatas((List<Object[]>)map.get("columnDatas"));
        if (list != null) {
            HSSFCellStyle rowStyle = hssfWorkbook.createCellStyle();
            // 左对齐
            rowStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
            // 设置边框
            rowStyle.setBorderBottom((short) 1);
            rowStyle.setBorderLeft((short) 1);
            rowStyle.setBorderRight((short) 1);
            rowStyle.setBorderTop((short) 1);
            HSSFFont rowFont = hssfWorkbook.createFont();
            rowFont.setFontHeightInPoints((short) 10);
            // 设置字体
            rowFont.setFontName("微软雅黑");
            rowStyle.setFont(rowFont);

            HSSFCell cell = null;
//            List<Object[]> list = this.getColumnDatas(reportList);
            for (Object[] object : list) {
                // 设置行样式
                HSSFRow excelRow = excelSheet.createRow(record++);
                excelRow.setHeight((short) 350);
                for (int i = 0; i < object.length; i++) {
                    // 设置列样式
                    cell = excelRow.createCell(i);
                    cell.setCellStyle(rowStyle);
                    // 填充列值
                    cell.setCellValue(getNullValue(object[i]).toString());
                }
            }
        }

        //是否要插入图片
        if(null != map.get("imagePath")){
            BufferedImage bufferImg = null;
            //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            bufferImg = ImageIO.read(new File(map.get("imagePath").toString()));
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
            double height = bufferImg.getHeight();
            double width = bufferImg.getWidth();
            //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
            HSSFPatriarch patriarch = excelSheet.createDrawingPatriarch();
            //anchor主要用于设置图片的属性
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023,100,(short) 1, list.size()+5, (short)(1+width/100), (short)(list.size()+5+height/20));
            anchor.setAnchorType(3);
            //插入图片
            patriarch.createPicture(anchor, hssfWorkbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
        }
    }
    /**
     * 功能描述: 获取当前日期
     *
     * @return
     */
    protected String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 功能描述: 判断所给参数是否为NULL
     *
     * @param o 参数对象
     * @return
     */
    protected Object getNullValue(Object o) {
        return o != null ? o : "";
    }

    /**
     * 功能描述: 获取列名
     *
     * @return
     */
    protected abstract List<String> getColumnNames(List<String> list);

    /**
     * 功能描述: 获取数据
     *
     * @param reportList
     * @return
     */
    protected abstract List<Object[]> getColumnDatas(List<Object[]> reportList);

    /**
     * 功能描述: 获取Excel表格标题
     *
     * @return
     */
    protected abstract String getTitle();

    /**
     * 功能描述: 获取Excel表格名称
     *
     * @return String
     */
    protected String getFileName(String fileName ,HttpServletRequest request){
//        String date = this.getDate();
        return FuncUtils.encodeFilename(fileName, request)+".xls";
    };
}