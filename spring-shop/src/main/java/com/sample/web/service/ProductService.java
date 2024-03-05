package com.sample.web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.ProductMapper;
import com.sample.vo.Company;
import com.sample.vo.Product;
import com.sample.web.dto.Criteria;
import com.sample.web.dto.ListDto;
import com.sample.web.dto.Pagination;
import com.sample.web.form.ProductCreateForm;

@Service
public class ProductService {
	
	@Autowired
	ProductMapper productMapper;	
	
	@Autowired
	private FileService fileService;
	
	/**
	 * ProductCreateForm객체를 전달받아서 신규 상품으로 등록한다
	 * @param form 신규 상품정보가 포함된 ProductCreateForm객체를 말한다. 
	 */
	public void createProduct(ProductCreateForm form) {
	      String filename = fileService.upload(form.getPhotofile());
	      
	      Company company = Company.builder()
	    		  			.no(form.getCompanyNo())
	    		  			.build();
	      
	      
	      // ProductCreateForm 객체에 저장된 값으로 Product 객체를 생성하고, 초기화한다
	      Product product = Product.builder()
	            .name(form.getName())
	            .description(form.getDescription())
	            .price(form.getPrice())
	            .filename(filename)
	            .stock(form.getStock())
	            .company(company)
	            .build();
	      
	      productMapper.insertProduct(product);
	   }
	
	/**
	 * 목록 조회에 필요한 정보를 담고 있는 Criteria 객체를 전달받아서 목록을 조회한다.<p>
	 * @param criteria  criteria 몰록조회에 필요한 정보가 들어있는 객체다.
	 * @return 상품정보와 페이징처리 정보가 저장된 객체를 반환한다.
	 */
	   public ListDto<Product> getProducts(Criteria criteria) {
		      int totalRows = productMapper.getTotalRows(criteria);
		      
		      // 현재 페이지번호, 총데이터 개수, 총 페이지 개수, 총 블록 개수, 현재 블록번호, 범위 시작 번호, 범위 끝 번호, 페이지 시작 번호, 페이지 끝번호
		      Pagination pagination = new Pagination(criteria.getPage(), totalRows,criteria.getRows());
		      // 현재 페이지 번호에 해당하는 조회범위를 Criteria객체에 저장한다.
		      criteria.setBegin(pagination.getBegin());
		      criteria.setEnd(pagination.getEnd());
		      
		      // 상품목록을 조회한다.
		      // criteria 객체에는 rows, sort, keyword, begin, end 값이 설정되어 있다.
		      List<Product> productList = productMapper.getProducts(criteria);
		      
		      ListDto<Product> dto = new ListDto<Product>(productList, pagination);
		      
		      return  dto;
		   }


		public Product getProductDetail(int no) {
			return productMapper.getProductByNo(no);
		}
		
	
		 public Product getProducts(int no) {
		     return productMapper.getProductByNo(no);
		  }
	
		public void deleteProducts(List<Integer> noList) {
			productMapper.deleteProducts(noList);
			
		 }
	}

