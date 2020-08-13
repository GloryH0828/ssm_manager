package com.gloryh.service;

import com.gloryh.entity.Fixlog;
import com.gloryh.entity.Putin;
import com.gloryh.entity.Stock;

import java.util.List;

public interface StockService {
    public List<Stock> findByType(int type);

    public List<Stock> findByQuantity(int type, int quantity);

    public List<Fixlog> loadWorker();

    public List<Fixlog> findFixLogInfoByID(Integer id);

    public void outOfStorage(Fixlog fixlog);

    public List<Fixlog> findBorrowed();

    public void itemStorage(Putin putin);

    public int itemReturn(Integer newCount, Integer oldCount, Integer fixLogId, String opName, String toolName);
}
