package com.ninhtinphuocquynh.shopee.config;

import com.cloudinary.Cloudinary;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cloudinary")
public class CloudinaryConfig {
    private String cloud_name;
    private String api_key;
    private String api_secret;
    private String secure;
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary cloudinary = new Cloudinary();
        cloudinary.config.cloudName = cloud_name;
        cloudinary.config.apiKey = api_key;
        cloudinary.config.apiSecret = api_secret;
        return cloudinary;
    }
}
