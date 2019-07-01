package cn.itcast.springboot.mybatis.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excelExport")
public class ExcelExport {



    @GetMapping("/downloadAllClassmate")
    @ResponseBody
    public void downloadAllClassmate(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("对账单明细");
        
        HSSFFont headfont = workbook.createFont();   
        headfont.setFontName("黑体");   
        headfont.setFontHeightInPoints((short) 22);// 字体大小 

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String fileName = "中原通ETC_高速消费汇总单_" + simpleDateFormat.format(new Date()) + ".xls";


        int rowNum = 0;

        HSSFRow rows = sheet.createRow(rowNum);
        rows.createCell(0).setCellValue("时间");
        rows.createCell(1).setCellValue("交易记录数量");
        rows.createCell(2).setCellValue("付款交易总量");
        rows.createCell(4).setCellValue("正常交易");
        rows.createCell(6).setCellValue("争议交易总量");
        rows.createCell(8).setCellValue("争议确认记账交易");
        rows.createCell(10).setCellValue("争议确认不记账交易");

        /*HSSFRow rows1 = sheet.createRow(rowNum+1);
        rows1.createCell(2).setCellValue("笔数");
        rows1.createCell(3).setCellValue("金额");
        rows1.createCell(4).setCellValue("笔数");
        rows1.createCell(5).setCellValue("金额");
        rows1.createCell(6).setCellValue("笔数");
        rows1.createCell(7).setCellValue("金额");
        rows1.createCell(8).setCellValue("笔数");
        rows1.createCell(9).setCellValue("金额");
        rows1.createCell(10).setCellValue("笔数");
        rows1.createCell(11).setCellValue("金额");*/

        /*CellRangeAddress callRangeAddress = new CellRangeAddress(0,1,0,0);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress);

        CellRangeAddress callRangeAddress1 = new CellRangeAddress(0,1,1,1);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress1);

        CellRangeAddress callRangeAddress2 = new CellRangeAddress(0,1,2,2);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress2);*/

        /*CellRangeAddress callRangeAddress2 = new CellRangeAddress(0,0,2,3);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress2);

        CellRangeAddress callRangeAddress3 = new CellRangeAddress(0,0,4,5);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress3);

        CellRangeAddress callRangeAddress4 = new CellRangeAddress(0,0,6,7);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress4);

        CellRangeAddress callRangeAddress5 = new CellRangeAddress(0,0,8,9);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress5);

        CellRangeAddress callRangeAddress6 = new CellRangeAddress(0,0,10,11);//起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress6);*/

        HSSFCellStyle boderStyle = workbook.createCellStyle();




         //垂直居中
       /* boderStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        boderStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式*/

        
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }   
    /***
     * 创建表头
     * @param sheet
     */
    private void createTitle(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow(3);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0, 3766);
        sheet.setColumnWidth(1, 3766);
        sheet.setColumnWidth(2, 3766);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("id");

        cell = row.createCell(1);
        cell.setCellValue("姓名");

        cell = row.createCell(2);
        cell.setCellValue("年龄");
    }
}