package br.com.mtz.cleanarch.application.response;

import java.util.List;

public class PageResponse<T> {

    private List<T> content;
    private Integer page;
    private Integer size;
    private Boolean isLast;
    private Integer totalPages;

    public PageResponse(List<T> content, Integer page, Integer size, Boolean isLast, Integer totalPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.isLast = isLast;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public static <T> PageResponse from(
        List<T> content,
        Integer page,
        Integer size,
        Boolean isLast,
        Integer totalPages
    ) {
        return new PageResponse(content, page, size, isLast, totalPages);
    }

}
