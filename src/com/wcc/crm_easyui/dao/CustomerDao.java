package com.wcc.crm_easyui.dao;

import com.wcc.crm_easyui.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Description:
 * @ClassName: CustomerDao
 * @Auther: changchun_wu
 * @Date: 2018/11/8 23:06
 * @Version: 1.0
 **/
public interface CustomerDao {
    Integer findCount(DetachedCriteria criteria);

    List<Customer> findByPage(DetachedCriteria criteria, Integer begin, Integer rows);

    void save(Customer customer);
}
