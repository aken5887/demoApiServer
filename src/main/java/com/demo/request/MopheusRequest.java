package com.demo.request;

import lombok.Getter;

import java.util.Map;

@Getter
public class MopheusRequest {
    private Map<String, Object> head;
    private Map<String, Object> body;
}
