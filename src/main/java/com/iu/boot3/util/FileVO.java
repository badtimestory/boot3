package com.iu.boot3.util;

import lombok.Data;

@Data
public class FileVO {

	// 파일 번호
	private Long FileNum;
	// 저장된 파일이름
	private String fileName;
	// 원본파일 이름
	private String oriName;
}
