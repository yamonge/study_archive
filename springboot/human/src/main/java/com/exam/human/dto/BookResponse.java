package com.exam.human.dto;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // 이거 추가

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {
    // 필수로 public static을 붙여야 다른 패키지에서 읽을 수 있습니다.
    public ResponseData response;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseData {
        public List<DocWrapper> docs;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocWrapper {
        public BookDto doc;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookDto {
        public String bookname;
        public String authors;
    }
}