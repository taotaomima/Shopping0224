package com.gtt.shoppingstoreback.servie;

import com.alibaba.fastjson.JSON;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingstoreback.dao.OrderDetailMapper;
import com.gtt.shoppingstoreback.dao.OrderMapper;
import com.gtt.shoppingstoreback.dto.in.OrderCreateIn;
import com.gtt.shoppingstoreback.dto.in.OrderProductIn;
import com.gtt.shoppingstoreback.dto.out.OrderHistoryListOut;
import com.gtt.shoppingstoreback.dto.out.OrderShowOut;
import com.gtt.shoppingstoreback.dto.out.ProductShowOut;
import com.gtt.shoppingstoreback.enumeration.OrderStatus;
import com.gtt.shoppingstoreback.po.Address;
import com.gtt.shoppingstoreback.po.Order;
import com.gtt.shoppingstoreback.po.OrderDetail;
import com.gtt.shoppingstoreback.po.OrderHistory;
import com.gtt.shoppingstoreback.vo.OrderProductVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private ProductService productService;
    @Resource
    private AddressService addressService;
    @Resource
    private OrderHistoryService orderHistoryService;

    @Override
    @Transactional
    public Long checkOut(OrderCreateIn orderCreateIn,Integer customerId) {
        List<OrderProductIn> orderProductInList = orderCreateIn.getOrderProductInList();
        List<OrderProductVo> orderProductVos = orderProductInList.stream().map(orderProductIn -> {
            ProductShowOut productShowOut = productService.getById(orderProductIn.getProductId());
            OrderProductVo orderProductVo = new OrderProductVo();
            orderProductVo.setProductId(productShowOut.getProductId());
            orderProductVo.setProductCode(productShowOut.getProductCode());
            orderProductVo.setProductName(productShowOut.getProductName());
            Integer quantity=orderProductIn.getQuantity();
            orderProductVo.setQuantity(quantity);
            Double unitPrice = productShowOut.getPrice() * productShowOut.getDiscount();
            orderProductVo.setUnitPrice(unitPrice);
            Double totalPrice = unitPrice * quantity;
            orderProductVo.setTotalPrice(totalPrice);
            Integer unitrewordPoints = productShowOut.getRewordPoints();
            orderProductVo.setRewordPoints(unitrewordPoints);
            Integer totalRewordPoints = unitrewordPoints*quantity;
            orderProductVo.setTotalRewordPoints(totalRewordPoints);
            return orderProductVo;
        }).collect(Collectors.toList());

        Double allTotalPrice = orderProductVos.stream().mapToDouble(p -> p.getTotalPrice()).sum();
        int allTotalRewordPoints = orderProductVos.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte) OrderStatus.ToProcess.ordinal());
        order.setTotalPrice(allTotalPrice);
        order.setRewordPoints(allTotalRewordPoints);
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);

        orderMapper.insertSelective(order);
        Long orderId = order.getOrderId();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setShipMethod(orderCreateIn.getShipMethod());
        orderDetail.setShipPrice(5.0);
        Address shipaddress = addressService.getById(orderCreateIn.getShipAddressId());
        orderDetail.setShipAddress(shipaddress.getContent());

        orderDetail.setPayMethod(orderCreateIn.getPayMethod());
        orderDetail.setInvoicePrice(allTotalPrice);
        Address invoiceAddress = addressService.getById(orderCreateIn.getInvoiceAddressId());
        orderDetail.setInvoiceAddress(invoiceAddress.getContent());

        orderDetail.setComment(orderCreateIn.getComment());
        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVos));

        return orderId;
    }

    @Override
    public Page<Order> getByCustomerId(Integer pageNum, Integer customerId) {
        PageHelper.startPage(pageNum,10);
        Page<Order> page = orderMapper.getByCustomerId(customerId);
        return page;
    }

    @Override
    public OrderShowOut getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);
        OrderShowOut orderShowOut = new OrderShowOut();
        orderShowOut.setOrderId(orderId);
        orderShowOut.setStatus(order.getStatus());
        orderShowOut.setTotalPrice(order.getTotalPrice());
        orderShowOut.setRewordPoints(order.getRewordPoints());
        orderShowOut.setCreateTimeTamp(order.getCreateTime().getTime());
        orderShowOut.setUpdaeTimeTamp(order.getUpdateTime().getTime());

        orderShowOut.setShipMethod(orderDetail.getShipMethod());
        orderShowOut.setShipAddress(orderDetail.getShipAddress());
        orderShowOut.setShipPrice(orderDetail.getShipPrice());
        orderShowOut.setPayMethod(orderDetail.getPayMethod());
        orderShowOut.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOut.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOut.setComment(orderDetail.getComment());

        List<OrderProductVo> orderProductVos = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVo.class);
        orderShowOut.setOrderProductVos(orderProductVos);

        List<OrderHistory> orderHistoryList = orderHistoryService.getByOrderId(orderId);
        List<OrderHistoryListOut> orderHistoryListOuts = orderHistoryList.stream().map(orderHistory -> {
            OrderHistoryListOut historyList = new OrderHistoryListOut();
            historyList.setComment(orderHistory.getComment());
            historyList.setOrderStatus(orderHistory.getOrderStatus());
            historyList.setTimestamp(orderHistory.getTime().getTime());
            return historyList;
        }).collect(Collectors.toList());

        orderShowOut.setOrderHistoryListOuts(orderHistoryListOuts);

        return orderShowOut;
    }
}
