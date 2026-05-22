package com.ex.spring_jap_board.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReq {
    private String memberEmail;
    private String memberPwd;
}
