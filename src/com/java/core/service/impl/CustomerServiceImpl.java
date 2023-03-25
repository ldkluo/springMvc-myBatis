package com.java.core.service.impl;

import com.java.common.utils.Page;
import com.java.core.dao.CustomerDao;
import com.java.core.po.Customer;
import com.java.core.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
客户管理
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public Page<Customer> findCustomerList(Integer page, Integer rows, String custName,
                                           String custSource, String custIndustry, String custLevel) {
        //创建客户对象
        Customer customer = new Customer();
        //判断客户名称
        if (StringUtils.isNoneBlank(custName)){
            customer.setCust_name(custName);
        }
        //判断客户信息来源
        if (StringUtils.isNoneBlank(custSource)){
            customer.setCust_source(custSource);
        }
        if(StringUtils.isNoneBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }
        //判断客户级别
        if (StringUtils.isNoneBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        //当前页
        customer.setStart((page-1) * rows);
        //每页数
        customer.setRows(rows);
        //查询客户列表
        List<Customer> customers = customerDao.selectCustomerList(customer);
        //查询客户列表总记录数
        Integer count = customerDao.selectCustomerListCount(customer);
        //创建Page返回对象
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    public int createCustomer(Customer customer){
        return customerDao.createCustomer(customer);
    }
    /*
    通过id获取客户信息
     */

    @Override
    public Customer getCustomerById(Integer id) {
       Customer customer =  customerDao.getCustomerById(id);
       return customer;
    }
    /*
    更新客户
     */
    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }
    /*
    删除客户
     */
    @Override
    public int deleteCustomer(Integer id) {
        return customerDao.deleteCustomer(id);
    }
}
