package com.wcc.crm_easyui.domain;

import java.util.List;

/**
 * @Description:
 * @ClassName: PageUtils
 * @Auther: changchun_wu
 * @Date: 2018/10/25 3:19
 * @Version: 1.0
 **/
public class PageUtils<T> {

    private Integer currentPage;     //当前页
    private Integer pageSize;       //每页显示个数
    private Integer totalPage;      //总页数
    private Integer totalCount;     //总记录数
    private List<T> list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
