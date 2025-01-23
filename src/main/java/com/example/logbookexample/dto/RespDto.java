package com.example.logbookexample.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RespDto {
    private final String id;
    private final String password;
    private final String email;

    public static RespDto from(ReqDto reqDto) {
        return new RespDto(reqDto.getId(), reqDto.getPassword(), reqDto.getEmail());
    }
}
