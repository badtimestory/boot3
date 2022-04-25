package com.iu.boot3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.boot3.product.ProductMapper;
import com.iu.boot3.product.ProductVO;

@SpringBootTest
class ProductMapperTest {

	@Autowired
	private ProductMapper productMapper;
	
	@Test
	void setAddTest() throws Exception {
		for(int i = 0; i < 100; i++) {
			
			if(i % 10 == 0) {
				Thread.sleep(1000);
			}
			
			ProductVO productVO = new ProductVO();
			productVO.setProductName("TestName" + i);
			productVO.setProductPrice(10000L);
			productVO.setProductCount(100L);
			
			int result = productMapper.setAdd(productVO);
		}
		
		System.out.println("loop Finish");
	}

}
