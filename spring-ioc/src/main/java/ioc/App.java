package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml"); 
		// ClassPathXmlApplicationContext("context.xml") : 객체 생성, 조립 담당 context.xml을 전달.
		ProductService productService = ctx.getBean(ProductService.class);
		// ctx.getBean(ProductService.class); ProductService.class(내가 꺼내오고 싶은 객체의 설계도 정보) 객체의 설계도 정보를 제공하는 리터럴
		
		productService.신규상품등록();
		productService.상품상세정보조회();
		productService.상품정보수정();
		
	}
}
