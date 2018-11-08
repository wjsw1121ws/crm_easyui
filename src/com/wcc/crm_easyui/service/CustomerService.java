package com.wcc.crm_easyui.service;

import com.wcc.crm_easyui.domain.Customer;
import com.wcc.crm_easyui.domain.PageUtils;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @Description:
 * @ClassName: CustomerService
 * @Auther: changchun_wu
 * @Date: 2018/11/8 23:07
 * @Version: 1.0
 **/
public interface CustomerService {
    PageUtils<Customer> findByPage(DetachedCriteria criteria, Integer page, Integer rows);

    void save(Customer customer);
}
