package com.example.project.BackendSpring.Utilities;

public class TemplateApi {
    private Object Data;
    private Object[] Datas;
    private String Message;
    private boolean Success;
    private boolean Fail;
    private int PageNumber;
    private int PageSize;
    private int TotalElement;
    private int TotalPages;

    public TemplateApi(Object data, Object[] datas, String message, boolean success, boolean fail, int pageNumber, int pageSize, int totalElement, int totalPages) {
        Data = data;
        Datas = datas;
        Message = message;
        Success = success;
        Fail = fail;
        PageNumber = pageNumber;
        PageSize = pageSize;
        TotalElement = totalElement;
        TotalPages = totalPages;
    }

    public TemplateApi(String message, boolean success, boolean fail) {
        Message = message;
        Success = success;
        Fail = fail;
    }
    public TemplateApi() {
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public Object[] getDatas() {
        return Datas;
    }

    public void setDatas(Object[] datas) {
        Datas = datas;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public boolean isFail() {
        return Fail;
    }

    public void setFail(boolean fail) {
        Fail = fail;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotalElement() {
        return TotalElement;
    }

    public void setTotalElement(int totalElement) {
        TotalElement = totalElement;
    }

    public int getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(int totalPages) {
        TotalPages = totalPages;
    }
}
