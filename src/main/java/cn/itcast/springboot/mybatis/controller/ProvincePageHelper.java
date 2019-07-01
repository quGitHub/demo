package cn.itcast.springboot.mybatis.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;
import cn.itcast.springboot.mybatis.entity.Province;
import cn.itcast.springboot.mybatis.service.ProvinceService;
import cn.itcast.springboot.mybatis.vo.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/provincePageHelper")
@Api(description = "分页查询")
public class ProvincePageHelper {

private static final Logger logger = LoggerFactory.getLogger(ProvincePageHelper.class);


	@Autowired
	private ProvinceService provinceService;
	 
	
	@Value("${pagehelper.pageSize}")
	private String pageSize;
	
	
    @ApiOperation("分页查询操作")
    @GetMapping("/queryPage")
    @ResponseBody
    public Message queryPage(int i){
       	    List<Province> page = provinceService.queryPage(i, Integer.parseInt(pageSize));
    	    logger.info("查询数据"+page.size());
    	    /**
    	     * 2、取分页信息  
    	     * 分页后，实际返回的结果list类型是Page<E>,如果想取出分页信息，需要强制转换为Page<E>  
    	     */
      	    Page<Province> listCountry = (Page<Province>)page;  
    	      
    	    long total = listCountry.getTotal();
    	    System.out.println(total);
            
            Message message=new Message();
            message.setDate(listCountry);
            message.setSuccess(true);
            return message;
    }
}
