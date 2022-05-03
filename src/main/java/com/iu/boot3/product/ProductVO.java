package com.iu.boot3.product;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {
	
	/*
		PRODUCTNUM BIGINT AUTO_INCREMENT,
		PRODUCTNAME VARCHAR(200),
		PRODUCTPRICE BIGINT,
		PRODUCTCOUNT BIGINT,
		PRODUCTDETAIL VARCHAR(1000),
		CONSTRAINT PR_PN_PK PRIMARY KEY (PRODUCTNUM)
	 */
	
	private Long productNum;
	@NotBlank
	private String productName;
	@Min(value = 100)
	private Long productPrice;
	@Range(min=1, max=1000)
	private Long productCount;
	@NotBlank
	private String productDetail;
	private String id;
	@NotNull
	private Integer sale;
	
	private List<ProductFilesVO> productFilesVO;

}
