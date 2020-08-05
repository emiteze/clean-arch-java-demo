package br.com.mtz.cleanarch.domain;

import java.util.List;

public class Page<T> {

    private List<T> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer total;

    public Page(List<T> content, Integer pageNumber, Integer pageSize, Integer total) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean isLast() {
        return this.pageNumber +1 >= this.totalPages();
    }

    public Integer totalPages() {
        if (this.content.isEmpty() && this.total == 0) {
            return 1;
        } else {
            return Double.valueOf(Math.ceil(this.total / this.pageSize)).intValue();
        }
    }

    public Integer size() {
        return this.content.size();
    }

}
