package com.wcc.crm_easyui.service.impl;

import com.wcc.crm_easyui.dao.CustomerDao;
import com.wcc.crm_easyui.domain.Customer;
import com.wcc.crm_easyui.domain.PageUtils;
import com.wcc.crm_easyui.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @ClassName: CustomerServiceImpl
 * @Auther: changchun_wu
 * @Date: 2018/11/8 23:08
 * @Version: 1.0
 **/
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public PageUtils<Customer> findByPage(DetachedCriteria criteria, Integer page, Integer rows) {
        PageUtils<Customer> pageUtils = new PageUtils<>();
        pageUtils.setCurrentPage(page);
        pageUtils.setPageSize(rows);
        Integer totalCount = customerDao.findCount(criteria);
        pageUtils.setTotalCount(totalCount);
        Double tc = totalCount.doubleValue();
        Double ceil = Math.ceil(tc / rows);
        pageUtils.setTotalPage(ceil.intValue());
        Integer begin = (page-1)*rows;
        List<Customer> list = customerDao.findByPage(criteria,begin,rows);
        pageUtils.setList(list);
        return pageUtils;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }
}
