package com.yps.service;

import org.springframework.web.multipart.MultipartFile;

public interface PredictService {

    Integer validateImage(MultipartFile file);

    String predictDiagnostic(MultipartFile file);

}
