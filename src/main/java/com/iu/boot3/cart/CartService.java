package com.iu.boot3.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	// 장바구니 리스트
	public List<CartVO> getList(CartVO cartVO) throws Exception {
		return cartMapper.getList(cartVO);
	}
	
	// 장바구니 추가
	public int setAdd(CartVO cartVO) throws Exception {
		return cartMapper.setAdd(cartVO);
	}

}
