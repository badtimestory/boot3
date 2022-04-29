package com.iu.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.boot3.util.Pager;

@Mapper
public interface ProductMapper {
	
	// List
	public List<ProductVO> getList(Pager pager) throws Exception;
	
	// 전체 리스트 갯수
	public Integer getTotalCount(Pager pager) throws Exception;
	
	// detail
	public ProductVO getDetail(ProductVO productVO) throws Exception;
	
	// Product 입력
	public int setAdd(ProductVO productVO) throws Exception;
	
	// File 입력
	public int setFileAdd(ProductFilesVO productFilesVO) throws Exception;

}
