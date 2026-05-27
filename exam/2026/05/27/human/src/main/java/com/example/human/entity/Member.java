package com.example.human.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true, length = 100)
    private String memberEmail;

    @Column(nullable = false)
    private String memberPwd;

    @Column(nullable = false, length = 20)
    private String memberRole;

    private String refreshToken;
}