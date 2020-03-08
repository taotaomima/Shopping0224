package com.gtt.shoppingproductback.service;

import com.gtt.shoppingproductback.dao.ReturnHistoryMapper;
import com.gtt.shoppingproductback.po.Return;
import com.gtt.shoppingproductback.po.ReturnHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {
    @Resource
    private ReturnHistoryMapper returnHistoryMapper;
    @Resource
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        List<ReturnHistory> listByReturnId = returnHistoryMapper.getListByReturnId(returnId);
        return listByReturnId;
    }

    @Override
    public Long carete(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return aReturn = new Return();
        aReturn.setReturnId(returnHistory.getReturnId());
        aReturn.setUpdateTime(new Date());
        returnService.update(aReturn);
        return returnHistoryId;
    }
}
