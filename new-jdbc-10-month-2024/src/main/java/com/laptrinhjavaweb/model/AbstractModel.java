package com.laptrinhjavaweb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createBy;
    private String modifiedBy;
    private List<T> listResult = new ArrayList<>();
    private int page;
    private Integer maxPageItem;
    private Integer totalPage;
    private Integer totalItem;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<T> getListResult() {
        return listResult;
    }
    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public Integer getMaxPageItem() {
        return maxPageItem;
    }
    public void setMaxPageItem(Integer maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalItem() {
        return totalItem;
    }
    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }
}
