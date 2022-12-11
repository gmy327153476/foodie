package com.soft.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件工具类
 * @author spw
 * @date 2022/1/20
 */
@Slf4j
public class FileUtils {

    /**
     * multipartFile transfer file
     * @param multipartFile 上传文件
     * @return
     */
    public static File multipartFile2File(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        File file = null;
        try {
            file = File.createTempFile(UUID.randomUUID().toString().replaceAll("-",""), suffix);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error("multipartFile transfer file error: {}", e);
        }
        return file;
    }
}
