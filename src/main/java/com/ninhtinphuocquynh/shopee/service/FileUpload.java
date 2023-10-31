package com.ninhtinphuocquynh.shopee.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileUpload {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
