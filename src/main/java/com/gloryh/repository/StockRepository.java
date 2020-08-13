package com.gloryh.repository;

import com.gloryh.entity.Fixlog;
import com.gloryh.entity.Putin;
import com.gloryh.entity.Stock;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 */
public interface StockRepository {
    public List<Stock> findByType(int type);

    public List<Stock> findByQuantity(int type, int quantity);

    public List<Fixlog> loadWorker();

    public List<Fixlog> findFixLogInfoByID(Integer id);

    public void outOfStorage(Fixlog fixlog);

    public List<Fixlog> findBorrowed();

    public int countPutIn(String name);

    public void insertPutIn(Putin putin);

    public void addItemByName(String name, int count, int type);

    public void insertItem(String name, int count, int type ,int correspondType);

    public int itemReturn(Date date, Integer newCount, Integer oldCount, Integer fixLogId, String opName, String toolName);
}
