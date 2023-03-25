package com.java.core.service;

import com.java.common.utils.Page;
import com.java.core.po.Customer;

public interface CustomerService {
    //查询客户列表
    public Page<Customer> findCustomerList(Integer page,Integer rows,
                                           String custName,String custSource,
                                           String custIndustry,String custLevel);

   public int createCustomer(Customer customer);

   public Customer getCustomerById(Integer id);

   public int updateCustomer(Customer customer);

    public int deleteCustomer(Integer id);
}
