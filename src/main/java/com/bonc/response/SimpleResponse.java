package com.bonc.response;

public class SimpleResponse {

    private Object context;

    public SimpleResponse(Object context) {
        this.context = context;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }
}
