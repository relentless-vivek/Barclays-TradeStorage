package com.db.tradestorage.dao;

import com.db.tradestorage.model.Trade;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface TradeDao {


    public  static Map<String,Trade> tradeMap =new ConcurrentHashMap<>();


    public void save(Trade trade);

    List<Trade> findAll();

    Trade findTrade(String tradeId);
}
