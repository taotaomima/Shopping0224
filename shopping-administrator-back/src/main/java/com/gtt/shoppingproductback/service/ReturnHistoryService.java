package com.gtt.shoppingproductback.service;


import com.gtt.shoppingproductback.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {
    List<ReturnHistory> getListByReturnId(Integer returnId);
    Long carete(ReturnHistory returnHistory);
}
