package cn.itcast.springboot.mybatis.mapper;
import cn.itcast.springboot.mybatis.entity.Regeister;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RegeisterMapper extends Mapper<Regeister>,MySqlMapper<Regeister>{
	 
} 