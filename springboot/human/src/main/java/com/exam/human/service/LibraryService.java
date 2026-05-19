package com.exam.human.service;

import com.exam.human.config.ApiConfig;
import com.exam.human.dto.BookResponse;
import com.exam.human.dto.LibResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryService {
    private final RestTemplate restTemplate = new RestTemplate();

    public BookResponse getPopularBooks() {
        String url = ApiConfig.BASE_URL + "loanItemSrch?authKey=" + ApiConfig.AUTH_KEY + "&format=json&pageSize=1";

        // 1. 헤더 설정 (브라우저인 척 하기)
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            // 2. [핵심] BookResponse.class가 아니라 String.class로 통째로 받기
            // 서버는 '글자'로 받겠다고 하면 406 에러를 내지 않습니다.
            String json = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

            // 3. 받은 글자를 BookResponse 상자에 담기
            return new com.fasterxml.jackson.databind.ObjectMapper().readValue(json, BookResponse.class);

        } catch (Exception e) {
            System.out.println("에러 발생: " + e.getMessage());
            return null;
        }
    }

    public LibResponse getLibraryList() {
        // 도서관 조회 API 주소 (다른 엔드포인트)
        String url = ApiConfig.BASE_URL + "libSrch?authKey=" + ApiConfig.AUTH_KEY + "&format=json&pageSize=1";

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            String json = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
            return new com.fasterxml.jackson.databind.ObjectMapper().readValue(json, LibResponse.class);
        } catch (Exception e) {
            return null;
        }
    }
}