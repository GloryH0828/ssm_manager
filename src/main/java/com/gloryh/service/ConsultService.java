package com.gloryh.service;

import com.gloryh.entity.Consult;
import com.gloryh.entity.Page;

public interface ConsultService {
    public void addConsult(Consult consult);

    public Page repairList(int current);
}
