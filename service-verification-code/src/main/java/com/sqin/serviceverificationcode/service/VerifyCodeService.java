package com.sqin.serviceverificationcode.service;

import com.sqin.internalcommon.dto.ResponseResult;
import com.sqin.internalcommon.dto.serviceverificationcode.VerifyCodeResponse;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 22:11 2021/5/5
 **/
public interface VerifyCodeService {

    ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);

}
