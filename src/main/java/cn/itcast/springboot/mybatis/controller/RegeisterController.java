package cn.itcast.springboot.mybatis.controller;
import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.itcast.springboot.mybatis.entity.Regeister;
import cn.itcast.springboot.mybatis.mapper.RegeisterMapper;
import cn.itcast.springboot.mybatis.service.RegisterService;
import cn.itcast.springboot.mybatis.vo.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/regeisterController")
@Api(description = "用户信息")
public class RegeisterController {	
/*	@Autowired
	private RegeisterMapper regeisterMapper;
	
	
	    @ApiOperation("根据手机号查询用户")
		@GetMapping("/selectOne")
	    @ResponseBody
		public Message selectOne(String tel){
			
	    	Regeister regeister=new Regeister();
	    	regeister.setTel(tel);	    	
	    	Regeister selectOne = regeisterMapper.selectOne(regeister);
			Message message=new Message();
			message.setSuccess(true);
			message.setDate(selectOne);
			return message;
	    }*/
			
		   @Autowired
		   private RegisterService  registerService;
		
		    //倒计时，用与模拟高并发
	        private static final int threadNum=400;
		    
		    private CountDownLatch cdl=new CountDownLatch(threadNum);
		    

		    @ApiOperation("根据手机号查询用户")
			@GetMapping("/selectOne")
		    @ResponseBody
			public void selectOne(){
		    	Thread[] threads=new Thread[threadNum];
		    	for (int i = 0; i < threadNum; i++) {
					Thread  thread=new Thread(new RegeisterS("3690e18e2cd611e8807400ffa9128934","18838954590","李四","1234567"));
					
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
