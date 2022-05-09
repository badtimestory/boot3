package com.iu.boot3.cart;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
	/*
		CREATE TABLE CART (
		CARTNUM BIGINT AUTO_INCREMENT,
		ID VARCHAR(200),
		PRODUCTNUM BIGINT,
		COUNT BIGINT,
		REGDATE DATETIME,
		CONSTRAINT CART_CN_PK PRIMARY KEY (CARTNUM),
		CONSTRAINT CART_ID_FK FOREIGN KEY (ID) REFERENCES MEMBER (ID),
		CONSTRAINT CART_PN_FK FOREIGN KEY (PRODUCTNUM) REFERENCES PRODUCT (PRODUCTNUM)
		);
	 
	*/
	
	// 카트 번호
	private Long cartNum;
	// 아이디
	private String id;
	// 물건 번호
	private Long productNum;
	// 수량
	private Long count;
	// 날짜
	private Date regDate;
	
	

}
