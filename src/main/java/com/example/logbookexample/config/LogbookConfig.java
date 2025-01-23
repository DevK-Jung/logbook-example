package com.example.logbookexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.core.*;
import org.zalando.logbook.json.JsonBodyFilters;

import java.util.Set;

import static org.zalando.logbook.core.Conditions.*;

@Configuration
public class LogbookConfig {

    private static final String SECRET = "<secret>";

    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .condition(
                        exclude( // 특정 요청 로깅 제외
                                requestTo("/api/samples/exclude"),
                                contentType(MediaType.APPLICATION_OCTET_STREAM_VALUE),
                                header("x-secret", "true")
                        )
                )
                .queryFilter(QueryFilters.replaceQuery("password", SECRET)) // 쿼리 파라미터 Secret 값으로 대체하여 로깅
                .pathFilter(PathFilters.replace("/api/samples/path/{test}", SECRET)) // 특정 경로 패턴 Secret 값으로 대체하여 로깅
                .headerFilter(HeaderFilters.replaceHeaders(HttpHeaders.AUTHORIZATION, SECRET)) // 헤더 값 Secret 값으로 대체하여 로깅
                .bodyFilter(JsonBodyFilters.replaceJsonStringProperty(Set.of("password", "email"), "<secret>")) // body 특정 필드 값 Secret 값으로 대체하여 로깅
                .sink(new DefaultSink( // 로깅 설정
                        new DefaultHttpLogFormatter(), // 로깅 포맷 설정
                        new DefaultHttpLogWriter() // 로깅 출력 설정
                ))
                .build();
    }

}
