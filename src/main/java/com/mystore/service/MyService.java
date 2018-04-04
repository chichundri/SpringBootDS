package com.mystore.service;

public interface MyService {

	void handleProcess(int i, String fromDate, String toDate);
	void handleException(String fromDate, String toDate, Exception e);

}
