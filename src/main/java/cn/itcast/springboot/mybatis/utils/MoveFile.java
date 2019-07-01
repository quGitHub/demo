package cn.itcast.springboot.mybatis.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: st
 * Date: 2017-11-08
 * Time: 22:02
 */
@Component
public class MoveFile {
	private static final Logger logger = LoggerFactory.getLogger(MoveFile.class);
    public static void moveFile(String from, String to) throws IOException {
        try {
            File before = new File(from);
            File filterDir = new File(to);
            if (before.isFile()){
                OutputStream outputStream = new FileOutputStream(filterDir);
                outputStream.write(Files.readAllBytes(Paths.get(before.getAbsolutePath())));
                outputStream.flush();
                outputStream.close();
                before.delete();
                return;
            }
            logger.info("moveFile开始扫描文件");

            if (!before.exists()){
                before.mkdirs();
            }

            if(!filterDir.exists()){
                filterDir.mkdirs();
            }

            if(before.listFiles().length > 0){
                File[] files = before.listFiles();
                logger.info("moveFile文件扫描完毕，文件数为："+files.length);
                int i = 1;
                for (File file : files){
                    logger.info("开始处理文件，当前第"+i+"个");

                    OutputStream outputStream = new FileOutputStream(new File(to + file.getName()));
                    outputStream.write(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                    outputStream.flush();
                    outputStream.close();
                    file.delete();
                    logger.info("第"+i+"个文件处理完成");
                    i++;

                }
            }else {
                logger.info("未扫描到文件");
            }
        }catch (Exception e){
            logger.error("处理文件失败 " + e.toString());
            e.printStackTrace();
        }
        logger.info("文件全部处理完成");
    }

    public static void main(String[] args) throws Exception {
    	String from = "d:\\consumer\\17_CONSUMER_2018020700_02B07AF9363A59CFF9F235117CE7A8C2.TXT";
    	String to = "d:\\consumer\\after\\17_CONSUMER_2018020700_02B07AF9363A59CFF9F235117CE7A8C2.TXT";
    	moveFile(from, to);
	}
}
