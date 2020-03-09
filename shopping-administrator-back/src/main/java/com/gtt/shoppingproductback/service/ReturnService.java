package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.RetuenSearchIn;
import com.gtt.shoppingproductback.po.Return;

public interface ReturnService {
    Page<Return> search(RetuenSearchIn retuenSearchIn,Integer pageNum);

    Return getById(Integer returnId);

    void update(Return aReturn);
}
