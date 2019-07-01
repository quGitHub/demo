package cn.hacz.edu.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @version 1.0
 * @Author: quziyuan
 * @Date: 2018/11/9 14:04
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class test2 {


    //日期操作 LocalDate  只包含年月日
    @Test
    public void  test1(){
        //获取当前时间
        /*LocalDate now = LocalDate.now();//2018-11-09

        Admin admin=new Admin();
        admin.setDate(now);
        System.out.println("----------------------------->"+admin.getDate());

        //获取年,月，日
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();

        System.out.println("================================>"+"年: "+year+"月: " +monthValue+ "日: "+dayOfMonth);*/


        //计算两个日期之间包含多少天、周、月、年。可以用java.time.Period类完成该功能。下面例子中将计算日期与将来的日期之间一共有几个月
        LocalDate now = LocalDate.now();
        LocalDate localDate=LocalDate.of(2017,10,10);
        Period period= Period.between(now, localDate);

        //日期类型变成字符串
        DateTimeFormatter  dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = dateTimeFormatter.format(now);//时间转字符串


        //字符串变成日期类型
        DateTimeFormatter  dateTimeFormatters=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date="2018-02-03";
        LocalDate parse = LocalDate.parse(date, dateTimeFormatters);

        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2018, Month.JANUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);


        System.out.println("===============================>字符串变成时间格式:"+parse);


        System.out.println("===============================>时间格式变成字符串:"+format);
        System.out.println("==================================>"+"年: "+Math.abs(period.getYears())+"  月: "+ Math.abs(period.getMonths()));

        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("******************************************>"+formatted);
    }


    @Test
    public void test2(){
        /*LocalDateTime local = LocalDateTime.ofInstant(  (Date) .toInstant, ZoneId.of("Asia/Shanghai"));

        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai")).toInstant());*/

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(format);


        Admin admin=new Admin();
        admin.setCreateDate(LocalDate.now());
        LocalDateTime localDateTime = LocalDateTime.now();
        admin.setUpdateDate(localDateTime);
        System.out.println("+++++++++++++++++++++++++++++++++++>"+admin.getUpdateDate());
        System.out.println("----------------------------------->"+admin.getCreateDate());


        //当前时间减去一天,一月,一年
        LocalDateTime localDateTime1 = LocalDateTime.now().minusDays(1);
        LocalDateTime localDateTime2 = LocalDateTime.now().minusMonths(1);
        LocalDateTime localDateTime3 = localDateTime.now().minusYears(1);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+localDateTime1);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+localDateTime2);
        System.out.println("######################################"+localDateTime3);

        //当前时间加一天,一月,一年
        LocalDateTime localDateTime4 = LocalDateTime.now().plusDays(1);
        LocalDateTime localDateTime5 = LocalDateTime.now().plusMonths(1);
        LocalDateTime localDateTime6 = LocalDateTime.now().plusYears(1);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$>"+localDateTime4);
        System.out.println("***********************>"+localDateTime5);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^>"+localDateTime6);


        //判断时间前后
        LocalDateTime  dateTime=LocalDateTime.of(2018,11,10,16,12,12);
        boolean after = LocalDateTime.now().isAfter(dateTime);//判断是否在后
        System.out.println("判断是否在后  "+after);

        boolean before = LocalDateTime.now().isBefore(dateTime);
        System.out.println("判断是否在前 "+before);
    }


    @Test
    public  void  test(){
        Integer total = Integer.valueOf(336)/100+1;
        System.out.println(total);
    }
}