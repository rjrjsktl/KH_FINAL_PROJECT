package com.kh.kgv.common.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kh.kgv.reserve.model.service.ReserveService;

@Component
public class UpdatePlayScheduling {
	
	@Autowired
	private ReserveService service;
	
	Logger logger =LoggerFactory.getLogger(UpdatePlayScheduling.class);
	
	// @Scheduled(fixedRate=30000)
    // @Scheduled(cron="0 * * * * *") // 매 분 0초마다
	// @Scheduled(cron="0 0 * * * *") // 정시마다
	// @Scheduled(cron="0 0 12 * * *") // 매일 12 정각마다
	// @Scheduled(cron="0 0 12 1, 11, 21 * *") // 매달 1,11,21일 매일 12 정각마다
	// @Scheduled(cron="0 0 14 * * 2") // 월요일 14시 마다
	// cron="초 분 시 일 월 요일 [년도]" - 요일 : 1(SUN) ~ 7(SAT)
	
	
	//  예매한 지 10분 넘게 결제 안 한 좌석 없애기
	
	@Scheduled(cron="0 */3 * * * *") // 매 10분마다
	public void removeSeat() {
		int result = service.removeSeat();
		logger.info("스케줄 결과 : 결제하지 않은 예매 " + result + "건이 삭제되었습니다.");
	}
	
	
	public void updateMovieWatchCount() {
		
	}
	
	
}
