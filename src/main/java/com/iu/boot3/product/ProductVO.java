package com.iu.boot3.product;

import java.util.List;

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
	private String productName;
	private Long productPrice;
	private Long productCount;
	private String productDetail;
	
	private List<ProductFilesVO> productFilesVO;

}
