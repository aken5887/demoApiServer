package com.demo.api;


import com.demo.dto.Join;
import com.demo.request.MopheusRequest;
import com.demo.response.UserResponse;
import com.demo.response.MopheusResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class ApiController {
    @CrossOrigin("*")
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @CrossOrigin("*")
    @PostMapping("/hello")
    public MopheusResponse hello_post(@RequestBody MopheusRequest request) {

        String category = (String) request.getBody().get("category");

        Map<String, Object> head = new HashMap<>();
        Map<String, Object> body = new HashMap<>();

        head.put("result_code","200");
        head.put("result_msg", "Success");

        List<UserResponse> userResponses
                = IntStream.range(0, 10)
                .mapToObj(i -> UserResponse.builder()
                        .id(Long.parseLong((i+1)+""))
                        .name(category+" 회원 ["+i+1+"]")
                        .age((20+i))
                        .salary((10000+(99*i)))
                        .dept("dev")
                        .build())
                .collect(Collectors.toList());

        body.put("userList", userResponses);

        return MopheusResponse.builder()
                .head(head)
                .body(body)
                .build();
    }

    @CrossOrigin("*")
    @PutMapping("/join")
    public MopheusResponse join(@RequestBody MopheusRequest request) throws JsonProcessingException {
        Map<String, Object> body = request.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        Join join = objectMapper.readValue(body.get("join").toString(), Join.class);
        return MopheusResponse.builder().build();
    }
}
