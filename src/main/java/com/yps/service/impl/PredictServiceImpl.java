package com.yps.service.impl;

import com.yps.client.PeriapicalClient;
import com.yps.client.RadiographClient;
import com.yps.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PredictServiceImpl implements PredictService {

    @Autowired
    private PeriapicalClient periapicalClient;

    @Autowired
    private RadiographClient radiographClient;

    @Override
    public Integer validateImage(MultipartFile file) {
        try {
            return radiographClient.validate(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String predictDiagnostic(MultipartFile file) {
        try {
            Integer valuePredict = periapicalClient.predict(file.getBytes());
            switch (valuePredict) {
                case 0:
                    return "Abseso periapical cronico";
                case 1:
                    return "Caries de Dentina";
                case 2:
                    return "Caries Profunda";
                case 3:
                    return "Diente definitivo retenido";
                case 4:
                    return "Reabsorcion osea localizada";
                case 5:
                    return "Tercer molar impactado";
                default:
                    return "Bad Request";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
