package cn.itcast.springboot.mybatis.mapper;

import java.util.List;
import java.util.Map;

import cn.itcast.springboot.mybatis.entity.Province;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ProvinceMapper extends Mapper<Province>,MySqlMapper<Province>{
	 
	public int update(Map<String,Object>  map);
	
	public List<Province>  selectListData();


} 