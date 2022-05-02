package com.iu.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.boot3.util.Filemanager;
import com.iu.boot3.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private Filemanager fileManager;
	
	// list
	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(productMapper.getTotalCount(pager));
		
		return productMapper.getList(pager);
	}
	
	// detail
	public ProductVO getDetail(ProductVO productVO) throws Exception {
		return productMapper.getDetail(productVO);
	}
	
	// add
	public int setAdd(ProductVO productVO, MultipartFile[] files) throws Exception {
		int result = productMapper.setAdd(productVO);
		
		// file add 눌러서 파일 첨부 안할 때
		if(files != null) {
			for (MultipartFile mf : files) {
				if(mf.isEmpty()) {
					continue;
				}
				// 1. File을 HDD에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/product");
				System.out.println("fileName 확인: " + fileName);
				// 2. 저장된 정보를 DB에 저장
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(mf.getOriginalFilename());
				productMapper.setFileAdd(productFilesVO);	
			}
		}
		return result;
	}
	
	// file add
	public int setFileAdd(ProductFilesVO productFilesVO) throws Exception {
		return productMapper.setFileAdd(productFilesVO);
	}
	
	// update
	public int setUpdate(ProductVO productVO, MultipartFile[] files) throws Exception {
		int result = productMapper.setUpdate(productVO);
		
		if(files != null) {
			for(MultipartFile file : files) {
				if(file.isEmpty()) {
					continue;
				}
				
			ProductFilesVO productFilesVO = new ProductFilesVO();
			String filename = fileManager.fileSave(file, "/resources/upload/product/");
			productFilesVO.setFileName(filename);
			productFilesVO.setOriName(file.getOriginalFilename());
			productFilesVO.setProductNum(productVO.getProductNum());
			
			result = productMapper.setFileAdd(productFilesVO);
			
			}
		}
		return result;
	}
		
	// fileDelete
	public int setFileDelete(ProductFilesVO productFilesVO) throws Exception {
		
		// DB에서 조회
		productFilesVO = productMapper.getFileDetail(productFilesVO);
		
		// HDD에서 삭제
//		boolean result = fileManager.fileDelete(productFilesVO.getFileName(), "/resources/upload/product/");
		
//		// DB 삭제
//		if(result) {
//			return productMapper.setFileDelete(productFilesVO);
//		}
		
		int check = productMapper.setFileDelete(productFilesVO);
		if(check > 0) {
			boolean result = fileManager.fileDelete(productFilesVO.getFileName(), "/resources/upload/product/");
		}
		
		// DB 삭제
		return check;
	}
	

}
