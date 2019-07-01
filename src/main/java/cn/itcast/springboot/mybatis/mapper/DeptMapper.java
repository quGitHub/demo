package cn.itcast.springboot.mybatis.mapper;

import cn.itcast.springboot.mybatis.entity.Dept;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface DeptMapper extends Mapper<Dept>, MySqlMapper<Dept> {

   Dept findAll(int id);
}