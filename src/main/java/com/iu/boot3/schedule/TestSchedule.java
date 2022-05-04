package com.iu.boot3.schedule;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.boot3.board.BoardMapper;
import com.iu.boot3.board.BoardVO;
import com.iu.boot3.util.Pager;

@Component
public class TestSchedule {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// 서버가 실행되고 initialDelayString초 있다가 fixedRate 간격으로 실행
//	@Scheduled(fixedRate = 1000, initialDelayString = "2000")
	public void fixRateSchedule() throws Exception {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		Thread.sleep(2000);
	}
	
//	@Scheduled(fixedDelay = 1000, initialDelayString = "2000")
	public void fixDelaySchedule() throws Exception {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		
	}
	
	@Scheduled(cron = "50 * * * * *")
	public void cronSchedule() throws Exception {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardVO> ar = boardMapper.getList(pager);
		System.out.println(ar);
	}
}
