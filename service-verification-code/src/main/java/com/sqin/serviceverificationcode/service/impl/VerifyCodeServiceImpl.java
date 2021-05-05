package com.sqin.serviceverificationcode.service.impl;

import com.sqin.internalcommon.dto.ResponseResult;
import com.sqin.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;
import com.sqin.serviceverificationcode.service.VerifyCodeService;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 22:12 2021/5/5
 **/
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Override
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        return null;
    }
}
