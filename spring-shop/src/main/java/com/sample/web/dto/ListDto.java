package com.sample.web.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;



/**
 * 목록을 표시할 때 필요한 정보를 표현하는 클래스이다.<p>
 * {@code List<?> items} 는 화면에 표시할 데이터를 담는 멤버변수이다.<p>
 * {@code Pagination paging} 는 화면에 표시할 데이터를 담는 멤버변수이다.<p>
 * @author nakyeong
 *
 */
@AllArgsConstructor
@Getter
@ToString
public class ListDto<T> {
	
	private List<?> items;
	private Pagination paging;
	
	
}
