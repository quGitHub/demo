package cn.itcast.springboot.mybatis.controller;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.mybatis.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/validController")
@Api(description = "注解验证")
public class ValidController {

	private static final Logger logger = LoggerFactory.getLogger(ValidController.class);

	
	@ApiOperation("测试注解验证")
	@ResponseBody
	@PostMapping("/testValid")
	public  void  testValid(@RequestBody @Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){  
			logger.info("参数异常:"+bindingResult.getFieldError().getDefaultMessage()); 
			
			Object[] arguments = bindingResult.getFieldError().getArguments();
			for (int i = 0; i < arguments.length; i++) {
				Object object = arguments[i];
				logger.info("参数异常:"+object);
			}
	    } 
		/*User user1=new User();
		BeanUtils.copyProperties(user, user1);
		System.out.println(user1.toString());*/
	}
}
