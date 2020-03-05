package com.gtt.shoppingproductback.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingproductback.dao.OrderDetailMapper;
import com.gtt.shoppingproductback.dao.OrderMapper;
import com.gtt.shoppingproductback.dto.out.OrderListOut;
import com.gtt.shoppingproductback.dto.out.OrderShowOut;
import com.gtt.shoppingproductback.po.Customer;
import com.gtt.shoppingproductback.po.Order;
import com.gtt.shoppingproductback.po.OrderDetail;
import com.gtt.shoppingproductback.vo.OrderProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private CustomerService customerService;


    @Override
    public Page<OrderListOut> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<OrderListOut> page = orderMapper.search();
        return page;
    }

    @Override
    public OrderShowOut getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOut orderShowOut = new OrderShowOut();
        orderShowOut.setOrderId(orderId);
        orderShowOut.setCustomerId(order.getCustomerId());
        Customer customer = customerService.getById(order.getCustomerId());
        orderShowOut.setCustomerName(customer.getRealName());
        orderShowOut.setStatus(order.getStatus());
        orderShowOut.setTotalPrice(order.getTotalPrice());
        orderShowOut.setRewordPoints(order.getRewordPoints());
        orderShowOut.setCreateTimeTamp(order.getCreateTime().getTime());
        orderShowOut.setUpdateTimeTamp(order.getUpdateTime().getTime());

        orderShowOut.setShipMethod(orderDetail.getShipMethod());
        orderShowOut.setShipAddress(orderDetail.getShipAddress());
        orderShowOut.setShipPrice(orderDetail.getShipPrice());
        orderShowOut.setPayMethod(orderDetail.getPayMethod());
        orderShowOut.setInvoicAddress(orderDetail.getInvoiceAddress());
        orderShowOut.setInvoicPrice(orderDetail.getInvoicePrice());
        orderShowOut.setComment(orderDetail.getComment());

        List<OrderProductVo> orderProductVos = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVo.class);
        orderShowOut.setOrderProductVos(orderProductVos);
        return orderShowOut;
    }
}
