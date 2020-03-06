package com.gtt.shoppingstoreback.servie;

import com.gtt.shoppingstoreback.dao.ReturnHistoryMapper;
import com.gtt.shoppingstoreback.po.ReturnHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Resource
    private ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getByReturnId(Integer returnId) {
        List<ReturnHistory> byReturnId = returnHistoryMapper.getByReturnId(returnId);
        return byReturnId;
    }
}
