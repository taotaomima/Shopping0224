package com.gtt.shoppingstoreback.servie;

import com.gtt.shoppingstoreback.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);
}
