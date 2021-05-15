package com.sqin.serviceverificationcode.service.impl;

import com.sqin.internalcommon.dto.ResponseResult;
import com.sqin.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;
import com.sqin.serviceverificationcode.service.VerifyCodeService;
import org.springframework.stereotype.Service;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 22:12 2021/5/5
 **/
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Override
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        // 校验 三档验证， 不能无限制发短信， redis 一分钟发了三次，不给发了，等等
        String code = String.valueOf((int)((Math.random()*9+1)*Math.pow(10, 5)));
        VerifyCodeResponse data = new VerifyCodeResponse();
        data.setCode(code);

        return ResponseResult.success(data);
    }

    public static void main(String[] args) {
        String code = String.valueOf((int)((Math.random()*9+1)*Math.pow(10, 5)));
        System.out.println(code);
    }
}
