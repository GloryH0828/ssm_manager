package com.gloryh.repository;

import com.gloryh.entity.Complaint;

import java.util.List;
import java.util.Map;

public interface ComplaintRepository {
    public void addComplaint(Complaint complaint);

    public int countForComplaint();

    public List<Map<String, Object>> complaintList(int startIndex, int pageSize);

    public Complaint findComplaintById(Integer id);

    public int solveComplaint(Integer id);
}
