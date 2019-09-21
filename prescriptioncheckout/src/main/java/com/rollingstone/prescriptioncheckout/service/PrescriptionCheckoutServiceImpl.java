package com.rollingstone.prescriptioncheckout.service;

import com.rollingstone.prescriptioncheckout.dao.PrescriptionRepository;
import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionCheckoutServiceImpl implements PrescriptionCheckoutService {

    PrescriptionRepository prescriptionRepository;

    public PrescriptionCheckoutServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public PrescriptionCheckout save(PrescriptionCheckout prescriptionCheckout) {
        PrescriptionCheckout savedprescriptionCheckout = prescriptionRepository.save(prescriptionCheckout);
        return savedprescriptionCheckout;
    }

    @Override
    public PrescriptionCheckout get(String id) {
        return prescriptionRepository.findByID(id);

    }

    @Override
    public List<PrescriptionCheckout> getPrescriptionCheckouts() {
        return prescriptionRepository.findAll();
    }

    @Override
    public void update(String id, PrescriptionCheckout updatedPrescriptionCheckout) throws Exception {
        PrescriptionCheckout existingPrescriptionCheckout = prescriptionRepository.findByID(id);
        System.out.println("Existing existingPrescriptionCheckout :"+existingPrescriptionCheckout);
        if(existingPrescriptionCheckout != null){
            existingPrescriptionCheckout = updatedPrescriptionCheckout;
            prescriptionRepository.save(existingPrescriptionCheckout);
        }
        else {
            throw new Exception("This PrescriptionCheckout does not exist");
        }
    }

    @Override
    public boolean delete(String id) {
        PrescriptionCheckout prescriptionCheckout = prescriptionRepository.findByID(id);
        if(prescriptionCheckout != null){
            prescriptionRepository.delete(prescriptionCheckout);
            return true;
        }
        return false;

    }

}
