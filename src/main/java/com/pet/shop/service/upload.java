package com.pet.shop.service;

import java.io.File;

/**
 * 七牛云图片上传
 * @author 昂太
 *
 */
public interface upload {
    /**
     * 图片上传到七牛云
     * @param file 文件
     * @param name 文件名
     */
    void uoload(File file,String name);
}
