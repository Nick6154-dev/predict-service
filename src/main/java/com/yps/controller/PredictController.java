package com.yps.controller;

import com.yps.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PredictController {

    @Autowired
    private PredictService predictService;

    @PostMapping("/validateImage")
    public ResponseEntity<?> validateImage(@RequestParam("image") MultipartFile image) {
        Integer value = predictService.validateImage(image);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(value);
    }

    @PostMapping("/predictImage")
    public ResponseEntity<?> predictImage(@RequestParam("image") MultipartFile image) {
        String result = predictService.predictDiagnostic(image);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

}
