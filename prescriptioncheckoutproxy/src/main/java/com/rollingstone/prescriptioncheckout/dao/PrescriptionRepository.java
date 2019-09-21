package com.rollingstone.prescriptioncheckout.dao;


import java.util.List;

import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PrescriptionRepository extends MongoRepository<PrescriptionCheckout, String> {

    PrescriptionCheckout findByID(String ID);

}
