package com.sample.web.form;

import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * 신규상품등록 할 때 사용되는 클래스
 * 
 * MultipartFile 꼭 기억 스프링에서 첨부파일 업로드를 지원하기 위해만들어놓은 객체 
 * 
 * */


@Getter
@Setter
@ToString
public class ProductCreateForm {
	
	
	private int companyNo;
	private String name;
	private int price;
	private int stock;
	private MultipartFile photofile; // multipartFile 스프링에서 첨부파일을 지원
	private String description;
	}

