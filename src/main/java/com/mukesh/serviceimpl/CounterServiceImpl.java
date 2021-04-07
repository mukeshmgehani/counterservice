package com.mukesh.serviceimpl;

import org.springframework.stereotype.Service;

import com.mukesh.service.CounterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CounterServiceImpl implements CounterService {
	
	private Integer counter=0;
	
	@Override
	public String increaseCouner() {
		log.info("CounterServiceImpl.increaseCouner() has been called ");
		counter++;
		return "Counter has been Increased by one";
	}

	@Override
	public String decreaseCouner() {
		log.info("CounterServiceImpl.decreaseCouner() has been called ");
		if(counter>0)counter--;
		return "Counter has been Decreased by one";
	}

	@Override
	public Integer getCounter() {
		log.info("CounterServiceImpl.getCounter() has been called ");
		return 	counter;
	}}
