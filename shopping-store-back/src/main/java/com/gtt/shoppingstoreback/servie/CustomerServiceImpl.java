package com.gtt.shoppingstoreback.servie;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gtt.shoppingstoreback.dao.CustomerMapper;
import com.gtt.shoppingstoreback.dto.in.CustomerRegisterIn;
import com.gtt.shoppingstoreback.enumeration.CustomerStatus;
import com.gtt.shoppingstoreback.po.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Integer register(CustomerRegisterIn customerRegisterIn) {
        Customer customer = new Customer();
        customer.setUsername(customerRegisterIn.getUsername());
        customer.setRealName(customerRegisterIn.getRealName());
        customer.setEmail(customerRegisterIn.getEmail());
        customer.setEmailVerified(false);
        customer.setMobile(customerRegisterIn.getMobile());
        customer.setMobileVerified(false);
        customer.setNewsSubscribed(customerRegisterIn.getNewsSubscribed());
        customer.setCreateTime(new Date());
        customer.setStatus((byte) CustomerStatus.Enable.ordinal());
        customer.setRewordPoints(0);

        String password = customerRegisterIn.getPassword();
        String hashToString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        customer.setEncryptedPassword(hashToString);

        customerMapper.insertSelective(customer);
        Integer customerId = customer.getCustomerId();
        return customerId;
    }

    @Override
    public Customer getByUsername(String username) {
        return customerMapper.getByUsername(username);
    }

    @Override
    public Customer getById(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public Customer getByEmail(String email) {
        Customer customer = customerMapper.selectByEmail(email);
        return customer;
    }
}
