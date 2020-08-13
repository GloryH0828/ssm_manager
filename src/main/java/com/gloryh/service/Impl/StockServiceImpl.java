package com.gloryh.service.Impl;

import com.gloryh.entity.Fixlog;
import com.gloryh.entity.Putin;
import com.gloryh.entity.Stock;
import com.gloryh.repository.StockRepository;
import com.gloryh.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;


    @Override
    public List<Stock> findByType(int type) {
        return stockRepository.findByType(type);
    }

    @Override
    public List<Stock> findByQuantity(int type, int quantity) {
        return stockRepository.findByQuantity(type,quantity);
    }

    @Override
    public List<Fixlog> loadWorker() {
        return stockRepository.loadWorker();
    }

    @Override
    public List<Fixlog> findFixLogInfoByID(Integer id) {
        return stockRepository.findFixLogInfoByID(id);
    }

    @Override
    public void outOfStorage(Fixlog fixlog) {
        stockRepository.outOfStorage(fixlog);
    }

    @Override
    public List<Fixlog> findBorrowed() {
        return stockRepository.findBorrowed();
    }

    @Override
    public void itemStorage(Putin putin) {
        putin.setTime(new Date());
        stockRepository.insertPutIn(putin);
        int isExist=stockRepository.countPutIn(putin.getName());
        if(isExist!=0){
            stockRepository.addItemByName(putin.getName(),putin.getCount(),putin.getType());
        }else {
            int correspondType =2;
            if(putin.getType()==0){
                correspondType=3;
            }
            stockRepository.insertItem(putin.getName(),putin.getCount(),putin.getType(),correspondType);
        }
    }

    @Override
    public int itemReturn(Integer newCount, Integer oldCount, Integer fixLogId, String opName, String toolName) {

        int result = stockRepository.itemReturn(new Date(),newCount,oldCount,fixLogId,opName,toolName);
        return result;
    }
}
