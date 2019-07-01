package cn.itcast.springboot.mybatis.mapper;

import cn.itcast.springboot.mybatis.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}