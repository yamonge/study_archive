package com.exam.human.controller;

import com.exam.human.dto.BookResponse;
import com.exam.human.dto.LibResponse;
import com.exam.human.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/popular")
    public String showPopular() {
        BookResponse res = libraryService.getPopularBooks();

        if (res == null) return "데이터를 가져오지 못했습니다.";

        // 결과를 보기 좋게 문자열로 만들어 브라우저에 출력
        String title = res.response.docs.get(0).doc.bookname;
        String author = res.response.docs.get(0).doc.authors;

        return "최신 인기 도서 1위: " + title + " (저자: " + author + ")";
    }

    @GetMapping("/library")
    public String showLibrary() {
        LibResponse res = libraryService.getLibraryList();

        // 경로: response -> libs(리스트) -> get(0) -> lib -> libName
        if (res != null && res.response != null && res.response.libs != null && !res.response.libs.isEmpty()) {
            String name = res.response.libs.get(0).lib.libName;
            String addr = res.response.libs.get(0).lib.address;
            return "검색된 도서관: " + name + " (주소: " + addr + ")";
        }

        return "데이터를 찾을 수 없습니다. (API 응답 확인 필요)";
    }
}