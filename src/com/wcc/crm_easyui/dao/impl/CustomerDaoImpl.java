package com.wcc.crm_easyui.dao.impl;

import com.wcc.crm_easyui.dao.CustomerDao;
import com.wcc.crm_easyui.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Description:
 * @ClassName: customerDaoImpl
 * @Auther: changchun_wu
 * @Date: 2018/11/8 23:06
 * @Version: 1.0
 **/
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public Integer findCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
        if (list!=null){
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<Customer> findByPage(DetachedCriteria criteria, Integer begin, Integer rows) {
        criteria.setProjection(null);
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, rows);
        return list;
    }

    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }
}
