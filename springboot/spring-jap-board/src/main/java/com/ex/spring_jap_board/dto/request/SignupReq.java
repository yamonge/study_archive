package com.ex.spring_jap_board.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupReq {
    private String memberEmail;
    private String memberPwd;
    private String memberName;
}
