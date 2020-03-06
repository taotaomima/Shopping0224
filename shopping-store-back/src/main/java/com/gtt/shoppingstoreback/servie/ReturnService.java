package com.gtt.shoppingstoreback.servie;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.po.Return;

public interface ReturnService {
    Integer create(Return ireturn);
    Page<Return> list(Integer pageNum,Integer customerId);
    Return getById(Integer returnId);
}
