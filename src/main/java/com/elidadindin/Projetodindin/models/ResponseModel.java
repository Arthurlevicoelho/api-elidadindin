package com.elidadindin.Projetodindin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseModel {

    private Object data;
    private List<String> messages;

    public ResponseModel(Object data, String message) {
        List<String> m = new ArrayList<String>();
        m.add(message);

        this.data = data;
        this.messages = m;
    }

    public ResponseModel(Object data, List<String> messages) {
        this.data = data;
        this.messages = messages;
    }
}
