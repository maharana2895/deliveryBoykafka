package com.deliveryBoy.DeliveryBoy.service;







//import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryBoy.DeliveryBoy.config.AppConfig;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
//	private Logger logger =  LoggerFactory.getLogger(KafkaService.class);
	
	public Boolean updateLocation(String loc) {
		
		this.kafkaTemplate.send(AppConfig.LOCATION_TOPIC_NAME, loc);
//		this.logger.info("message produced");
		return true;
		
	}

}
