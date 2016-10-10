package com.radish.biyu.webapi.dto;

import java.util.HashMap;
import java.util.List;

public class StampDTO {
    private Integer total = 0;
    private List<HashMap<String, Object>> list = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<HashMap<String, Object>> getList() {
        return list;
    }

    public void setList(List<HashMap<String, Object>> list) {
        this.list = list;
    }
}
