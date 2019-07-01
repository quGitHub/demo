package cn.itcast.springboot.mybatis.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.springboot.mybatis.entity.Province;
import cn.itcast.springboot.mybatis.entity.Regeister;
import cn.itcast.springboot.mybatis.mapper.RegeisterMapper;

@Service
public class RegisterService {
	
    private Lock lock = new ReentrantLock();

	@Autowired
	private RegeisterMapper  regeisterMapper;
	
	public void add(String id,String tel,String userName,String passWord) {
		
		 // 保存黑名单
        lock.lock();
        Regeister regeister=new Regeister();
		regeister.setId(id);
		Regeister selectOne = regeisterMapper.selectOne(regeister);
        try {        
        	if(selectOne==null){
        		Regeister regeisters=new Regeister();
        		regeisters.setId(id);
        		regeisters.setPassWord(passWord);
        		regeisters.setTel(tel);
        		regeisters.setUserName(userName);
                regeisterMapper.insert(regeisters);
        	}else {
        		System.out.println("1111111");
        	}        	
            // 保存黑名单
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
	}
}
