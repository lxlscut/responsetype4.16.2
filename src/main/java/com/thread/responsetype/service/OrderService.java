package com.thread.responsetype.service;

import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.service.usermodel.Odermodel;

public interface OrderService {
    Odermodel createorder(Integer userid,Integer itemid,Integer amout) throws Mexception;
}
