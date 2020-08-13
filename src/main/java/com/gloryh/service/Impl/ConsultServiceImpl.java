package com.gloryh.service.Impl;

import com.gloryh.entity.Consult;
import com.gloryh.entity.Page;
import com.gloryh.repository.ConsultRepository;
import com.gloryh.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConsultServiceImpl implements ConsultService {
    @Autowired
    private ConsultRepository consultRepository;

    @Override
    public void addConsult(Consult consult) {
        consultRepository.addConsult(consult);
    }

    @Override
    public Page repairList(int current) {
        int total = consultRepository.countForConsult();
        Page page=new Page(current,total);
        int end =page.getEnd();
        page.setEnd(end);
        page.setStart(page.getStart());
        page.setStartIndex(page.getStartIndex());
        List<Map<String,Object>> list =consultRepository.consultList(page.getStartIndex(),page.getPageSize());
        page.setList(list);
        return page;
    }
}
