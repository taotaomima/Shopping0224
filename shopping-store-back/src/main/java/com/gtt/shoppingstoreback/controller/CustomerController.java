package com.gtt.shoppingstoreback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gtt.shoppingstoreback.constant.ClientExceptionConstant;
import com.gtt.shoppingstoreback.dto.in.*;
import com.gtt.shoppingstoreback.dto.out.CustomerLoginOut;
import com.gtt.shoppingstoreback.dto.out.CustomerProfileOut;
import com.gtt.shoppingstoreback.exception.ClientException;
import com.gtt.shoppingstoreback.po.Customer;
import com.gtt.shoppingstoreback.servie.CustomerService;
import com.gtt.shoppingstoreback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.HashMap;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private JWTUtil jwtUtil;
    /*@Resource
    private SecureRandom secureRandom;
    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;
*/
    private HashMap<String, String> emailPwdResetCodeMap = new HashMap();

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterIn customerRegisterIn){
        Integer customerId = customerService.register(customerRegisterIn);
        return customerId;
    }
    @GetMapping("/login")
    public CustomerLoginOut login(CustomerLoginIn customerLoginIn) throws ClientException {
        Customer customer = customerService.getByUsername(customerLoginIn.getUsername());
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerLoginIn.getPassword().toCharArray(), encPwdDB);

        if (result.verified) {
            CustomerLoginOut customerLoginOut = jwtUtil.issueToken(customer);
            return customerLoginOut;
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
    }
    @GetMapping("/getProdile")
    public CustomerProfileOut getProfile(@RequestAttribute Integer customerId){
        Customer customer = customerService.getById(customerId);
        CustomerProfileOut customerGetProfileOut = new CustomerProfileOut();
        customerGetProfileOut.setUsername(customer.getUsername());
        customerGetProfileOut.setRealName(customer.getRealName());
        customerGetProfileOut.setMobile(customer.getMobile());
        customerGetProfileOut.setMobileVerified(customer.getMobileVerified());
        customerGetProfileOut.setEmail(customer.getEmail());
        customerGetProfileOut.setEmailVerified(customer.getEmailVerified());
        customerGetProfileOut.setCustomerId(customer.getCustomerId());
        return customerGetProfileOut;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody CustomerUpdateProfileIn customerUpdateProfileIn,@RequestAttribute Integer customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setUsername(customerUpdateProfileIn.getUsername());
        customer.setRealName(customerUpdateProfileIn.getRealName());
        customer.setMobile(customerUpdateProfileIn.getMobile());
        customer.setEmail(customerUpdateProfileIn.getEmail());
        customerService.update(customer);
    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdIn customerChangePwdIn,@RequestAttribute Integer customerId) throws ClientException {
        Customer customer = customerService.getById(customerId);
        String encPwdDB = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerChangePwdIn.getOrderPwd().toCharArray(), encPwdDB);

        if (result.verified) {
            String newPwd = customerChangePwdIn.getNewPwd();
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
            customer.setEncryptedPassword(bcryptHashString);
            customerService.update(customer);
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
    }

  /*  @GetMapping("/getPwdRestCode")
    public void getPwdRestCode(@RequestParam String email) throws ClientException {
        Customer customer = customerService.getByEmail(email);
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        byte[] bytes = secureRandom.generateSeed(3);
        String hex = DatatypeConverter.printHexBinary(bytes);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("jcart重置密码");
        message.setText(hex);
        mailSender.send(message);
        emailPwdResetCodeMap.put("PwdResetCode"+email, hex);
    }*/

    @PostMapping("/resetCode")
    public void resetCode(@RequestBody CustomerRestPwdIn customerRestPwdIn){ }



}
