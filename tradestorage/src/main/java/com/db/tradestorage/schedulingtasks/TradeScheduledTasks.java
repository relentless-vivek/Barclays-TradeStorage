
package com.db.tradestorage.schedulingtasks;

import com.db.tradestorage.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TradeScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(TradeScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	TradeService tradeService;

	@Scheduled(cron = "${trade.expiry.schedule}")//currentlly setup 30 min
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		tradeService.updateExpiryFlagOfTrade();
	}
}