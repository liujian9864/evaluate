package com.ecut.teachingevalutionsystem.model.param;

/**
 * Created by UI on 2017/12/29.
 */
public class Page {

    private int pageSize;

    private int currentPage;

    private int totalPage;

    private int totalCount;

    private String searchId;
    private String searchName;
    private String searchInstitution;
    private String searchClass;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchInstitution() {
        return searchInstitution;
    }

    public void setSearchInstitution(String searchInstitution) {
        this.searchInstitution = searchInstitution;
    }

    public String getSearchClass() {
        return searchClass;
    }

    public void setSearchClass(String searchClass) {
        this.searchClass = searchClass;
    }

    public int getTotalPage() {
        if(totalCount>pageSize){
            if(totalCount % pageSize == 0){
                totalPage = totalCount / pageSize;
            }else{
                totalPage = totalCount / pageSize +1;
            }

        }else{
            totalPage=1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public Page() {
    }
}
