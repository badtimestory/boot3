package com.iu.boot3.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.boot3.util.Pager;

@Mapper
public interface BoardMapper {
	
	// list
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	// detail
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
	
	// insert
	public int setAdd(BoardVO boardVO) throws Exception;
	
	// update
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	// delete
	public int setDelete(BoardVO boardVO) throws Exception;
	
	// board table count num
	public Integer getTotalCount(Pager pager) throws Exception;
	
	
	
	// file Add
	public int setFileAdd(BoardFilesVO boardFilesVO) throws Exception;
	
	// file Delete
	public int setFileDelete(BoardFilesVO boardFilesVO) throws Exception;
	
	// file Detail
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception;
	
	// file List
	public List<BoardFilesVO> getFileList(BoardVO boardVO) throws Exception;
	
}
