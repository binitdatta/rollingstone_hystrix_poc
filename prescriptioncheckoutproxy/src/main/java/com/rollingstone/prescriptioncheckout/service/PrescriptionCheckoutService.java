package com.rollingstone.prescriptioncheckout.service;

import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;

import java.util.List;

public interface PrescriptionCheckoutService {

    PrescriptionCheckout save(PrescriptionCheckout prescriptionCheckout);
    PrescriptionCheckout get(String id);
    List<PrescriptionCheckout> getPrescriptionCheckouts();
    void update(String id, PrescriptionCheckout product) throws Exception;
    boolean delete(String id);
}
