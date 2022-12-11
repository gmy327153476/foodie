package com.soft.utils;

import com.soft.config.OSSConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.Date;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2022/3/16 11:46
 */
@Slf4j
@Component
public class OSSUtil {

    private static final String OSS_FILE_PREFIX = "foodie/upload/";

    /**
     * 上传文件
     * @param file
     * @return
     */
    public static String upload(File file) {
        try {
            //上传文件地址
            String filePath = OSS_FILE_PREFIX + file.getName();
            //上传到oss
            OSSConfiguration.ossClient.putObject(OSSConfiguration.bucketName, filePath, file);

            //获取上传文件访问url
            //设置访问链接有效时间为10年
            Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
            URL url = OSSConfiguration.ossClient.generatePresignedUrl(OSSConfiguration.bucketName, filePath, expiration);
            if(url != null) {
                return StringUtils.split(url.toString(), "?")[0];
            }
        }catch (Exception e) {
            log.error("oss upload error:{}", e);
        }
        return null;
    }

    public static void delete(String fileName) {
        try {
            OSSConfiguration.ossClient.deleteObject(OSSConfiguration.bucketName, OSS_FILE_PREFIX + fileName);
        }catch (Exception e) {
            log.error("oss delete error:{}", e);
        }
    }
}
