package com.iu.boot3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.boot3.board.BoardFilesVO;
import com.iu.boot3.board.BoardMapper;
import com.iu.boot3.board.BoardVO;
import com.iu.boot3.util.Pager;

@SpringBootTest
class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;

	// list Test
	@Test
	void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardVO> ar = boardMapper.getList(pager);
		System.out.println("ar" + ar);
		assertEquals(10, ar.size());
	}
	
	// detail
	@Test
	void test() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(215L);
		boardVO = boardMapper.getDetail(boardVO);
		System.out.println(boardVO.toString());
		assertNotNull(boardVO);
	}
	
	// add Test
	// @Test
	void setAddTest() throws Exception {
		for (int i = 0; i < 100; i++) {			
			if(i % 10 == 0) {
				Thread.sleep(1000);
			}
			
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("Add Title" + i);
			boardVO.setWriter("Add Writer" + i);
			boardVO.setContents("Add Contents" + i);
			
			int result = boardMapper.setAdd(boardVO);
		}
		System.out.println("loop Finish");
		// assertEquals(1, result);
	}
	
	// update Test
	// @Test
	void setUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("Update Title");
		boardVO.setContents("Update Contents");
		boardVO.setNum(3L);
		
		int result = boardMapper.setUpdate(boardVO);
		assertEquals(1, result);
	}
	
	// delete Test
	// @Test
	void setDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4L);
		
		int result = boardMapper.setDelete(boardVO);
		assertEquals(1, result);
	}
	
	// file insert test
	// @Test
	void fileAddTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setNum(3L);
		boardFilesVO.setFileName("Add Test");
		boardFilesVO.setOriName("Add Test");
		
		int result = boardMapper.setFileAdd(boardFilesVO);
		assertEquals(1, result);
	}
	
	// file delete test
	// @Test
	void fileDeleteTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(4L);
		
		int result = boardMapper.setFileDelete(boardFilesVO);
		assertEquals(1, result);
	}
	
	// file detail test
	// @Test
	void fileDetailTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(211L);
		
		boardFilesVO = boardMapper.getFileDetail(boardFilesVO);
		System.out.println(boardFilesVO.toString());
		assertNotNull(boardFilesVO);
	}

}
