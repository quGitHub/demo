package cn.itcast.springboot.mybatis.bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 访问地址(端口号为8081)
 * http://localhost:8090/swagger-ui.html
 * @author lang
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 *
	 * @return
	 */
	@Bean
    public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.itcast.springboot.mybatis"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}


    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "SpringBoot-Mybatis REST API",
                "Springboot与mybatis整合",
                "1.0",
                "服务条款地址",
                new Contact("曲梓元", "", ""),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}