package com.sample.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor // 기본생성자 제공
@Getter
@Setter
@ToString
public class Employee {
	
	private int no;
	private String name;
	private String tel;
	private String email;
	private int salary;
	private Date hireDate;
	private Dept dept;  // 객체로 불러와ㅏㅏㅏㅏㅏ 
	private Date createdDate;
	private Date updatedDate;
	
	
	
}
