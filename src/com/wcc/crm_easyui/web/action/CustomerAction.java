package com.wcc.crm_easyui.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wcc.crm_easyui.domain.Customer;
import com.wcc.crm_easyui.domain.PageUtils;
import com.wcc.crm_easyui.service.CustomerService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @ClassName: CustomerAction
 * @Auther: changchun_wu
 * @Date: 2018/11/8 23:09
 * @Version: 1.0
 **/
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private Integer page = 1;
    private Integer rows = 3;

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    public String findAll() throws IOException {
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        PageUtils<Customer> pageUtils = customerService.findByPage(criteria,page,rows);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageUtils.getTotalCount());
        map.put("rows",pageUtils.getList());
        JSONObject jsonObject = JSONObject.fromObject(map);
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
        System.out.println(jsonObject.toString());
        return NONE;
    }
    public String save() throws IOException {
        Map<String,String> map = new HashMap<>();
        try {
            customerService.save(customer);
            map.put("msg","保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","保存失败!");
        }
        JSONObject jsonObject = JSONObject.fromObject(map);
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
        System.out.println(jsonObject.toString());
        return NONE;
    }
}
