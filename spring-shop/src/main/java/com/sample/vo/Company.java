package com.sample.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class Company {

	private int no;
	private String name;
	private String te;;
	private String zipcode;
	private String address1;
	private String address2;
	
	@Builder 
	public Company(int no, String name, String te, String zipcode, String address1, String address2) {
		super();
		this.no = no;
		this.name = name;
		this.te = te;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
	}


	
	
}
