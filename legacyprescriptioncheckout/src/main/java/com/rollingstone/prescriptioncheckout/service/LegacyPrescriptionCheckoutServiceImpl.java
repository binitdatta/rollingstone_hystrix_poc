package com.rollingstone.prescriptioncheckout.service;

import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegacyPrescriptionCheckoutServiceImpl implements LegacyPrescriptionCheckoutService {


    public LegacyPrescriptionCheckoutServiceImpl() {
    }

    @Override
    public PrescriptionCheckout save(PrescriptionCheckout prescriptionCheckout) {
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        return prescriptionCheckout;
    }





}
