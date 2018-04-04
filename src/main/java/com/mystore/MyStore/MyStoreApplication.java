package com.mystore.MyStore;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.mystore.config.AppConfig;
import com.mystore.service.MyService;
import com.mystore.service.MyServiceImpl;

@SpringBootApplication
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MyStoreApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MyStoreApplication.class, args);
		
		try (GenericApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
			MyService myService = springContext.getBean(MyServiceImpl.class);
			
			LocalDateTime now = LocalDateTime.now();
			String fromDate = now.toString();
			String toDate = now.toString();
			
			try {
				myService.handleProcess(1,fromDate, toDate);
			} catch (Exception e) {
//				logger.error("Exception occurs", e);
				System.out.println(e);
				myService.handleException(fromDate, toDate, e);
			}
		} catch (Exception e) {
//			logger.error("Exception occurs in loading Spring context: ", e);
			
			System.out.println("Exception occurs in loading Spring context: " + e);
		}
	}
}
