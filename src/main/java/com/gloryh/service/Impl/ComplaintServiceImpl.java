package com.gloryh.service.Impl;

import com.gloryh.entity.Complaint;
import com.gloryh.entity.Page;
import com.gloryh.repository.ComplaintRepository;
import com.gloryh.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public void addComplaint(Complaint complaint) {
        complaintRepository.addComplaint(complaint);
    }

    @Override
    public Page complaintList(int current) {
        int total =complaintRepository.countForComplaint();
        Page page =new Page(current,total);
        page.setEnd(page.getEnd());
        page.setStart(page.getStart());
        page.setStartIndex(page.getStartIndex());
        List<Map<String,Object>> list =complaintRepository.complaintList(page.getStartIndex(),page.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public Complaint findComplaintById(Integer id) {

        return complaintRepository.findComplaintById(id);
    }

    @Override
    public int solveComplaint(Integer id) {
        return complaintRepository.solveComplaint(id);
    }
}
