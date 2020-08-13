package com.gloryh.entity;

import java.util.List;
import java.util.Map;

public class Page {

    /**
     * 每页显示的条数
     */
    private int pageSize=5;
    /**
     * 当前页的页码
     */
    private int currentPage;

    /**
     * 数据库中查询到的总条数
     */
    private int totalSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 起始页记录索引
     */
    private int startIndex;
    /**
     * 当前页列表信息
     */
    private List<Map<String, Object>> list;

    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * 每页显示的页码个数
     */
    private int num=5;
    /**
     * 页面页码的起始值
     */
    private int start;

    /**
     * 页面显示页码的终止值
     */
    private int end;

    /**
     * 定义Page类接收的参数（totalSize和currentPage，即数据总数量和当前页码），用于对其他参数进行操作
     */
    public Page(int currentPage,int totalSize){
        this.totalSize=totalSize;
        setCurrentPage(currentPage);
    }

    /**
     * 定义为固定值，直接获取
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 由函数作为参数传递进入实体类
     * @return
     */
    public int getCurrentPage() {
        return currentPage;
    }

    public int setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return currentPage;
    }

    /**
     * 数据库查询总数后，由函数作为参数传递进入实体类
     * @return
     */
    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    /**
     * 总页码，由totalSize和pageSize计算得到
     * @return
     */
    public int getTotalPage() {
        totalPage=(totalSize%pageSize==0)?(totalSize/pageSize):(totalSize/pageSize+1);

        return totalPage;
    }

    /**
     * 起始记录的索引
     * 第i页   （i-1）*x（分页大小）
     * @return
     */

    public int getStartIndex() {

        return (currentPage-1)*pageSize;
    }


    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    /**
     * 页面显示的页码个数
     * @return
     */
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /**
     * 起始页的值
     * @return
     */
    public int getStart() {
        int start=currentPage-num/2;
        if(start<1){
            start=1;
        }
        return start;
    }


    public int getEnd() {
        int end=getStart()+num-1;
        int totalPage=getTotalPage();
        if(end>totalPage){
            end=totalPage;
        }
        return end;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalSize=" + totalSize +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", num=" + num +
                ", start=" + getStart() +
                ", end=" + getEnd() +
                '}';
    }
}
