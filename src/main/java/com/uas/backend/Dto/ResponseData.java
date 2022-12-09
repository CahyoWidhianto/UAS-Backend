package com.uas.backend.Dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {
    private boolean status;
    private List<String> massages = new ArrayList<>();
    private T payload;
    
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public List<String> getMassages() {
        return massages;
    }
    public void setMassages(List<String> massages) {
        this.massages = massages;
    }
    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }


    
}
