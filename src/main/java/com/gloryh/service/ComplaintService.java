package com.gloryh.service;

import com.gloryh.entity.Complaint;
import com.gloryh.entity.Page;

public interface ComplaintService {
    public void addComplaint(Complaint complaint);

    public Page complaintList(int current);

    public Complaint findComplaintById(Integer id);

    public int solveComplaint(Integer id);
}
