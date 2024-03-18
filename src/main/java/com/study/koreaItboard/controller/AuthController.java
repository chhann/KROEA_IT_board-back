package com.study.koreaItboard.controller;

import com.study.koreaItboard.dto.SignupReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) {
        System.out.println(signupReqDto);
        return ResponseEntity.created(null).body(true);
    }
}
