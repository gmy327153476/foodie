package com.soft.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2021/12/1 10:20
 */
@ApiModel(value = "分页对象")
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    @TableField(exist = false)
    @ApiModelProperty(value = "当前页码")
    private int pageNum;
    //每页的数量
    @TableField(exist = false)
    @ApiModelProperty(value = "每页数量")
    private int pageSize;
    //总记录数
    @TableField(exist = false)
    @ApiModelProperty(value = "总记录数")
    private long total;
    //总页数
    @ApiModelProperty(value = "总页数")
    @TableField(exist = false)
    private int pages;
    //结果集
    @ApiModelProperty(value = "结果集")
    @TableField(exist = false)
    private List<T> list;
    //是否为第一页
    @TableField(exist = false)
    @ApiModelProperty(value = "是否为第一页")
    private boolean isFirstPage = false;
    //是否为最后一页
    @ApiModelProperty(value = "是否为最后一页")
    @TableField(exist = false)
    private boolean isLastPage = false;
    @TableField(exist = false)
    @ApiModelProperty(value = "排序字段名")
    private String sort;// 排序字段名
    @TableField(exist = false)
    @ApiModelProperty(value = "按什么排序(asc,desc)")
    private String sortOrder;// 按什么排序(asc,desc)
    @TableField(exist = false)
    private String orderBy;// id desc

    public PageInfo() {
    }
    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.list = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.total = list.size();
        }
        if (list instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }


    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }


    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", navigatepageNums=");
        sb.append('}');
        return sb.toString();
    }

}