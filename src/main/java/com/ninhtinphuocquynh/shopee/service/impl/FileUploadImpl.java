package com.ninhtinphuocquynh.shopee.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ninhtinphuocquynh.shopee.service.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUploadImpl implements FileUpload {

    private final Cloudinary cloudinary;

    public FileUploadImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        Map<String, Object> params = ObjectUtils.asMap("public_id", UUID.randomUUID().toString());
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);

        return uploadResult.get("url").toString();
    }
}

