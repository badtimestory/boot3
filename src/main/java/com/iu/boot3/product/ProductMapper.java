package com.iu.boot3.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.boot3.util.Pager;

@Mapper
public interface ProductMapper {
	
	// List
	public List<ProductVO> getList(Pager pager) throws Exception;
	
	// Product 입력
	public int setAdd(ProductVO productVO) throws Exception;
	
	// Update
	public int setUpdate(ProductVO productVO) throws Exception;
	
	// 전체 리스트 갯수
	public Integer getTotalCount(Pager pager) throws Exception;
	
	// detail
	public ProductVO getDetail(ProductVO productVO) throws Exception;
	
	// File Detail
	public ProductFilesVO getFileDetail(ProductFilesVO productFilesVO) throws Exception;
	
	// File 입력
	public int setFileAdd(ProductFilesVO productFilesVO) throws Exception;
	
	// File 삭제
	public int setFileDelete(ProductFilesVO productFilesVO) throws Exception;

}
