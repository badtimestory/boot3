package com.iu.boot3.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.boot3.util.Filemanager;
import com.iu.boot3.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private Filemanager fileManager;
	
	// list
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(boardMapper.getTotalCount(pager));
		
		return boardMapper.getList(pager);
	}
	
	// add
	public int setAdd(BoardVO boardVO, MultipartFile[] files) throws Exception {
		System.out.println("Insert 전 : " + boardVO.getNum());
		int result = boardMapper.setAdd(boardVO);
		System.out.println("Insert 후 : " + boardVO.getNum());
		
		// file add 눌러서 파일 첨부 안할 때
		if(files != null && result > 0) {
			for (MultipartFile mf : files) {
				if(mf.isEmpty()) {
					continue;
				}
				
				// 1. File을 HDD에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/board");
				System.out.println("fileName 확인: " + fileName);
				// 2. 저장된 정보를 DB에 저장
				BoardFilesVO boardFilesVO = new BoardFilesVO();
				boardFilesVO.setNum(boardVO.getNum());
				boardFilesVO.setFileName(fileName);
				boardFilesVO.setOriName(mf.getOriginalFilename());
				result = boardMapper.setFileAdd(boardFilesVO);
				
				if(result < 1) {
					// board table insert한 것도 rollback
					throw new SQLException();
				}
			}
		}
		return result;
	}
	
	// detail
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		return boardMapper.getDetail(boardVO);
	}
	
	// update
	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}
	
	// delete
	public int setDelete(BoardVO boardVO) throws Exception {
		
		List<BoardFilesVO> ar = boardMapper.getFileList(boardVO);
		int result = boardMapper.setDelete(boardVO);
		
		System.out.println("File Size: " + ar.size());
		
		for(BoardFilesVO f : ar) {
			fileManager.fileDelete(f.getFileName(), "resources/upload/board");
		}
		
		return result;
	}
	
	// file detail
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception {
		return boardMapper.getFileDetail(boardFilesVO);
	}
	
	// file을 HDD에 저장하고 저장된 파일명을 return 
	public String setSummerFileUpload(MultipartFile files) throws Exception {
		
		String fileName = fileManager.fileSave(files, "resources/upload/board/");
		fileName = "/resources/upload/board/" + fileName;
		System.out.println("summernote filename : " + fileName);
		
		return fileName;
	}
	
	public boolean setSummerFileDelete(String fileName) throws Exception {
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
		System.out.println("문자열 인덱싱 결과확인 : " + fileName);
		
		return fileManager.fileDelete(fileName, "/resources/upload/board/");
	}

}
