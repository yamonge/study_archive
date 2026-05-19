package com.exam.human.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibResponse {
    public ResponseData response;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseData {
        // [수정] libs 자체가 리스트이며, 그 안에 LibWrapper(lib)가 들어있는 구조입니다.
        public List<LibWrapper> libs;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LibWrapper {
        public LibDto lib; // JSON의 "lib" 키와 일치
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LibDto {
        public String libName; // [주의] 대문자 N (PDF 4페이지 확인)
        public String address;
    }
}