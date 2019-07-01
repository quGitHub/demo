package cn.itcast.springboot.mybatis.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.itcast.springboot.mybatis.entity.Province;
import cn.itcast.springboot.mybatis.mapper.ProvinceMapper;
import cn.itcast.springboot.mybatis.vo.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Example;
@RestController
@RequestMapping("/provinceController")
@Api(description = "省份查询")
public class ProvinceController {

	
	private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

	
	@Autowired 
	private ProvinceMapper provincemapper;

	
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

    SimpleDateFormat formatS = new SimpleDateFormat("yyyy-MM-dd");  

	
    @ApiOperation("查询单个省份")
	@GetMapping("/selectOne")
    @ResponseBody
	public Message selectOne(){
		Province province=new Province();
		province.setPid("cb2a70bd6c1b4608b4f237717bbbc9be");
		logger.info("查询数据");
		Province selectOne = provincemapper.selectOne(province);
		
		Province province1=new Province();	
		Date createDate=new Date();
		//province1.setCreateTime(formatS.format(createDate));

		provincemapper.insert(province1);



		logger.info("更新数据库里面数据");
		Date updateDate=new Date();
		//province1.setUpdateTime(format.format(updateDate));
		Example example=new Example(Province.class);
		example.createCriteria().andEqualTo("province",selectOne.getProvince());
		
		//updateByExampleSelective是根据除主键以外字段作为条件来进行更新。
		//updateByExampleSelective 不更新的字段，在数据库里面保持不变
		int updateByExampleSelective = provincemapper.updateByExampleSelective(province1, example);
		
		
		//updateByExample  不更新的字段，会把原来数据覆盖掉，变成null
		//int updateByExampleSelective = provincemapper.updateByExample(province1, example);

		logger.info("返回json数据到页面");
		Message message=new Message();
		message.setDate(updateByExampleSelective);
	
		message.setSuccess(true);
		return message;		
    }
		/*		int updateByPrimaryKeySelective = provincemapper.updateByPrimaryKeySelective(province1);
*/		
		





	/*		int update = provincemapper.update(province1);
	}
	
    
    @ApiOperation("插入数据")
	@PostMapping("/add")
    @ResponseBody
	public int add(Province province){
        String uuidStr = UUID.randomUUID().toString().replace("-", "");
        province.setPid(uuidStr);
    	int insertSelective = provincemapper.insert(province);
        return insertSelective;
    }
    
    
    @ApiOperation("插入数据")
	@PostMapping("/addSelect")
    @ResponseBody
	public void addSelect(Province province){
    	String uuidStr = UUID.randomUUID().toString().replace("-", "");
        province.setPid(uuidStr);
    	int insertSelective = provincemapper.insertSelective(province);
        System.out.println(insertSelective);
    }
    
    
   
/*	public void selectList(String province,String provinceType){
        Example example =new Example(Province.class);  
    	
        example.createCriteria().andCondition("province=",province).andCondition("provinceType=",provinceType);
    	
        List<Province> selectByExample = provincemapper.selectByExample(example);	
    	System.out.println(selectByExample.get(0).getPid());
    	System.out.println(selectByExample.get(0).getProvince());
    	System.out.println(selectByExample.get(0).getProvinceType());*/
    @ApiOperation("查询多条数据")
   	@PostMapping("/selectList")
    @ResponseBody
    public void selectList(String province,String provinceType){
         Example example1 =new Example(Province.class);  
    	
         //example1.orderBy("provinceType");
         
         //排序操作
         //example1.setOrderByClause("provinceType DESC");
         
         //等于
         example1.createCriteria().andEqualTo("provinceTypes", provinceType);
         
         //添加条件
         //example.createCriteria().andCondition("province=",province).andCondition("provinceType=",provinceType);
         
         //模糊查询条件
         /*example1.createCriteria().andLike("provinceType", provinceType+"%");
         example1.createCriteria().andLike("provinceType", provinceType);*/
         
         /*
          * 多条件查询
         List<String> list=new ArrayList<String>();
         list.add("10000");
         list.add("20000");
         list.add("30000");
         example1.createCriteria().andIn("provinceType", list);*/
         
         
	   /*         
	    * 在两个之间
	    * example1.createCriteria().andBetween("provinceType", "10000", "30000");
	    */         

         
         /* provinceType等于10000或者20000
          * example1.createCriteria().andEqualTo("provinceType", "10000").orEqualTo("provinceType", "20000");
          */

         
         List<Province> selectByExample1 = provincemapper.selectByExample(example1);
         System.out.println(selectByExample1.size());
         //System.out.println(selectByExample1.get(0).getProvinceType());
         System.out.println(selectByExample1.get(0).getPid());
         System.out.println(selectByExample1.get(0).getProvince());
    }
    
    
    @ApiOperation("查询多条数据")
   	@PostMapping("/selectAllData")
    @ResponseBody
    public Message selectAllData(int pageNum,int pageSize){
    	Message message=new Message();
		PageHelper.startPage(pageNum, pageSize);
		List<Province>   provinceList=provincemapper.selectListData();
    	message.setDate(provinceList);
    	message.setSuccess(true);
    	return message;
    }
    
    @ApiOperation("更新数据")
   	@PostMapping("/updateData")
    @ResponseBody
    public Message updateData(String province,String provinceType){
    	Message message=new Message();
    	Map<String,Object>  map=new HashMap<String,Object>();
        map.put("provinces", province);
        map.put("provinceTypes", provinceType);
    	int update = provincemapper.update(map);
    	message.setDate(update);
    	message.setSuccess(true);
    	return message;
    }

	@ApiOperation("测试数据")
	@PostMapping("/test")
	@ResponseBody
	public Message test(){
		Message message=new Message();
		Province province=new Province();
		String id = UUID.randomUUID().toString().replace("-", "");
		province.setPid(id);
		province.setProvince("南阳1");
		province.setProvinceTypes("90000");
		/*LocalDate now = LocalDate.now();
		province.setCreateTime(now);
		province.setUpdateTime(LocalDateTime.now());*/
		//int  insertSelective = provincemapper.insertSelective(province);
		provincemapper.insert(province);
		//message.setDate(insertSelective);
		message.setSuccess(true);
		return message;
	}


	@ApiOperation("测试数据1")
	@PostMapping("/test1")
	@ResponseBody
	public Message test1(){
		Message message=new Message();
		Province province= provincemapper.selectByPrimaryKey("e7e7bd61b2cb4e978c8fe54053a1337e");
		System.out.println(province.getCreateTime());
		LocalDateTime updateTime = province.getUpdateTime();
		message.setSuccess(true);
		return message;
	}

}