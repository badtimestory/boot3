package com.iu.boot3.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
	
	// 장바구니 리스트
	public List<CartVO> getList(CartVO cartVO) throws Exception;
	
	// 장바구니 추가
	public int setAdd(CartVO cartVO) throws Exception;
	

}
