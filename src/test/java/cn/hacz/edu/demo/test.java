package cn.hacz.edu.demo;

import java.util.concurrent.CountDownLatch;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import cn.itcast.springboot.mybatis.service.RegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class test {
	
	
	   @Autowired(required=false)
	   private RegisterService  registerService;
	
	    //倒计时，用与模拟高并发
        private static final int threadNum=200;
	    
	    private CountDownLatch cdl=new CountDownLatch(threadNum);
	    
	    long timed=0L;
	    
	    
	    @Before
	    public void start(){
            System.out.println("开始测试");	    	
	    }
	    
	    @After
	    public void end(){
            System.out.println("测试结束"+(System.currentTimeMillis()-timed));	    	
	    }
	    
	    @Test
	    public void test() {
	    	Thread[] threads=new Thread[threadNum];
	    	for (int i = 0; i < threadNum; i++) {
				Thread  thread=new Thread(new RegeisterS("3690e18e2cd611e8807400ffa9128934","18838959372","李四","1234567"));
				
				threads[i]=thread;
				
				thread.start();
				//倒计时器倒计数一次
				cdl.countDown();
				
			}
	    	
	    	for (Thread thread : threads) {
	    		try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

	   }
	  
	  private class RegeisterS implements Runnable{
		     String id;
			 String tel;
			 String userName;
			 String passWord;

		public RegeisterS(String id, String tel, String userName, String passWord) {
				this.id = id;
				this.tel = tel;
				this.userName = userName;
				this.passWord = passWord;
			}



		@Override
		public void run() {
		    try {
				cdl.await();//等待其他线程就绪之后，在运行后续代码	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    registerService.add(id,tel,userName,passWord);
		}		  
		
	  }
	  
	  
	  
}
