package com.example.logbookexample.controller;

import com.example.logbookexample.dto.ReqDto;
import com.example.logbookexample.dto.RespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/samples")
public class SampleController {

    // exclude test api: 로깅 제외
    @GetMapping("/exclude")
    public String exclude() {
        return "exclude";
    }

    // exclude test api: 특정 Header 값 로깅 제외
    @GetMapping("/exclude/header")
    public String excludeHeader(@RequestHeader("x-secret") String xSecret) {
        return "excludeHeader";
    }

    // exclude test api: 특정 Content-Type 로깅 제외
    @GetMapping(value = "/exclude/content-type", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String excludeContentType() {
        return "excludeContentType";
    }

    // queryFiltering test api: 쿼리 파라미터 Secret 값으로 대체 로깅
    @GetMapping("/query")
    public String query(@RequestParam("password") String password) {
        return password;
    }

    // pathFilter test api: 쿼리 파라미터 Secret 값으로 대체 로깅
    @GetMapping("/path/{test}")
    public String path(@PathVariable("test") String test) {
        return test;
    }

    // headerFilter test api : 헤더 값 Secret 값으로 대체 로깅
    @GetMapping("/header")
    public String header(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        return authorization;
    }

    // bodyFilter test api : body 특정 필드 값 Secret 값으로 대체 로깅
    @PostMapping("/body")
    public RespDto body(@RequestBody ReqDto reqDto) {
        return RespDto.from(reqDto);
    }

    // bodyFilter test api : body list 특정 필드 값 Secret 값으로 대체 로깅
    @PostMapping("/body/list")
    public List<RespDto> body(@RequestBody List<ReqDto> reqDto) {
        return reqDto.stream()
                .map(RespDto::from)
                .toList();
    }
}
