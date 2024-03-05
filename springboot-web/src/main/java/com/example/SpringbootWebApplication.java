package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @SpringBootApplication
 *		이 어노테이션은 스프링부트 어플리케이션의 부트스트랩핑 클래스에 추가되는 어노테이션이다.
 *		해당 프로젝트(어플리케이션)이 스프링부터 어플리케이션을 나타내는 어노테이션이다.
 *		아래의 3가지 어노테이션으로 구성되어 있다.
 *
 *		@SpringBootCofiguration
 *			개발자가 추가한 빈을 자동으로 스프링 컨테이너의 빈으로 등록시킨다.
 *			개발자가 추가한 빈은 @Configuration 어노테이션이 부착된 클래스 내부에서 정의한 것이다.
 *			ex)
 *				@Configuration
 *					public class sampleConfig {
 *						@Bean
 *						PasswordEncorder passwordController {
 *							return new BCryPasswordEncorder();
 *						}
 *				}
 *
 **		@EnableAutoConfiguration -jar 라이브러리 의존성을 기반으로 자동으로 빈을 등록시킨다.
 *			스프링부트로 생성한 어플리케이션에 대해서 자동구성(AutoConfiguration)을 가능하게 해주는 어노테이션이다.
 *			사전에 미리 정의된 객체를 스프링 컨테이너의 빈으로 자동 등록되도록 한다.
 *			(스프링부트는 자동으로 라이브러리 의존성을 기반으로 사전에 미리 정의된 객체를 스프링 컨테이너의 빈으로 자동등록하고, 의존성 주입까지 완료한다.)
 *		@ComponentScan - @Component 가 적용된 클래스들을 스캔해서 자동으로 빈으로 등록시킨다.
 *			부트스트래핑 클래스가 위치한 패키지 및 그 하위패키지에서 클래스를 스캔하고, 스프링 컨테이너 빈으로 자동등록시킨다.
 *			개발자가 작성한 클래스 중에서 아래의 어노테이션이 부착된 것이 자동등록대상이다.(사전에 미리x)
 *			@Controller, @RestController, @ControllerAdvice, @RestControllerAdvice
 *			@Service, @Repository
 *			@Component
 *			@Configuration
 *
 */
@SpringBootApplication
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args); // 실행하면 스프링컨테이너가 생성된다.(
	}

}