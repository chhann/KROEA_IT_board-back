package com.study.koreaItboard.service;

import com.study.koreaItboard.dto.SignupReqDto;
import com.study.koreaItboard.entity.User;
import com.study.koreaItboard.exception.SaveException;
import com.study.koreaItboard.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean isDuplicatedByUsername(String username) {
        return userMapper.findUserByUsername(username) != null;
    }

    @Transactional(rollbackFor =  Exception.class)
    public void signup (SignupReqDto signupReqDto) {
        int successCount = 0;
        User user = signupReqDto.toEntity(passwordEncoder);
        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 1);

        if(successCount < 2) {
            throw  new SaveException();
        }
    }

    public String signin (SignupReqDto signupReqDto) {
        User user = userMapper.findUserByUsername(signupReqDto.getUsername());
        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }

        return null;
    }




}
