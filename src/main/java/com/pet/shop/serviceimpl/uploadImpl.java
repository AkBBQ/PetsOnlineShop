package com.pet.shop.serviceimpl;

import com.pet.shop.service.upload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.pet.shop.serviceimpl
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/4/5 2:47 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */
@Service
public class uploadImpl implements upload {
    @Value("${qiniu.AccessKey}")
    private String accessKey;

    @Override
    public void uoload() {
    }
}