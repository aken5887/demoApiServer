package com.demo.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;


@Getter
public class MopheusResponse {

     private Map<String, Object> head;
    private Map<String, Object> body;

    @Builder
    public MopheusResponse(Map<String, Object> head, Map<String, Object> body){
        this.head = head;
        this.body = body;
    }
}
