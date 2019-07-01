package cn.itcast.springboot.mybatis.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.itcast.springboot.mybatis.entity.Province;
import cn.itcast.springboot.mybatis.mapper.ProvinceMapper;

@Service
public class ProvinceService {

	@Autowired
	private ProvinceMapper provincemapper;
			
	public List<Province> queryPage(int pageNum, int pageSize) {
		 /**
 	      * 1、设置分页信息
 	      *  紧跟着的第一个select方法会被分页  
 	      */
	     PageHelper.startPage(pageNum, pageSize);	
	     List<Province> selectAll = provincemapper.selectAll();
	     return selectAll;
	}

	public  List<Province> selectAll() {

	 List<Province> selectAllS = provincemapper.selectAll();
	 return selectAllS;
	}


	@Async
	public void sendSms(){
		System.out.println("####sendSms####   2");
		/*IntStream.range(0, 5).forEach(d -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});*/
		System.out.println("####sendSms####   3");
	}
}
