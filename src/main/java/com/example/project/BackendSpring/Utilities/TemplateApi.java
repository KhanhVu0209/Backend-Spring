package com.example.project.BackendSpring.Utilities;

public class TemplateApi {
    private Object Payload;
    private Object[] Payloads;
    private String Message;
    private boolean Success;
    private boolean Fail;
    private int PageNumber;
    private int PageSize;
    private int TotalElement;
    private int TotalPages;

    public TemplateApi(Object payload, Object[] payloads, String message, boolean success, boolean fail, int pageNumber, int pageSize, int totalElement, int totalPages) {
        Payload = payload;
        Payloads = payloads;
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

    public Object getPayload() {
        return Payload;
    }

    public void setPayload(Object payload) {
        Payload = payload;
    }

    public Object[] getPayloads() {
        return Payloads;
    }

    public void setPayloads(Object[] payloads) {
        Payloads = payloads;
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
