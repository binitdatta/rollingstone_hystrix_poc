package com.rollingstone.prescriptioncheckout.service;

import com.rollingstone.prescriptioncheckout.dao.PrescriptionRepository;
import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;
import com.rollingstone.prescriptioncheckout.exceptions.HTTP400Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Service
public class PrescriptionCheckoutServiceImpl implements PrescriptionCheckoutService {

    PrescriptionRepository prescriptionRepository;

    public PrescriptionCheckoutServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public String save(PrescriptionCheckout prescriptionCheckout) {

        try {

            RestTemplate restTemplate = new RestTemplate();

            final String baseUrl = "http://localhost:"+7080+"/checkoutprescriptions/";
            URI uri = new URI(baseUrl);

            Thread.sleep(1000);

            ResponseEntity<String> result = restTemplate.postForEntity(uri, prescriptionCheckout, String.class);


            return "New Special Order PrescriptionCheckout has been saved with ID and we called the legacy app:" + prescriptionCheckout.getID();
        }
        catch(Exception e) {
            throw new HTTP400Exception("The Request did not have proper data", new Date(), e);
        }


    }



}
