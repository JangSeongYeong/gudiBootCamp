package kr.co.gudi.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling // 스케줄러 선언
@Component
public class ScheduleUtil {
	
	// 스케줄러는 프로그램과 생명주기를 함께 한다.
	// -> 켜질때 같이 켜지고, 꺼질때 같이 꺼진다. (즉, 서버를 킬때 같이 켜지고, 꺼질때 같이 꺼짐)
	
	Logger logger = LoggerFactory.getLogger(getClass());
	/*
	@Scheduled(fixedDelay = 1000)
	public void fixedDelay() {
		logger.info("이전 작업이 끝나고 1초 후 실행"); // 이전 작업이 끝나면 거기서부터 1초
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/*
	@Scheduled(fixedRate = 1000)
	public void fixedRate() {
		logger.info("무조건 1마다 실행"); // 무조건 1초
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
	
	// crontab
	// 초 분 시 일 월 요일 년도(일반적으로 생략)
	// 1 0 0 * * MON-FRI (매일 0시 0분 1초에 동작하도록) // 1을 추가한 이유는 0시 0분 0초에 동작하는게 너무 많음
	//@Scheduled(cron = "0/5 * * * * MON-FRI") // 0부터 시작해서 5초 (월요일부터 금요일까지)
	@Scheduled(cron = "5 * * * * MON-FRI") // 모든 5초마다 동작 (1분 5초, 2분 5초) | (월요일부터 금요일까지)
	public void cron() {
		logger.info("5초마다 실행"); // 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// 동작 예시
	// 2024-05-24 15:14:05.008[0;39m [32m INFO[0;39m [35m19536[0;39m [2m---[0;39m [2m[   scheduling-1] 5초마다 실행
	
	
}
