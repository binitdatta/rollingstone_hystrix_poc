package com.rollingstone.prescriptioncheckout.controller;

import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;
import com.rollingstone.prescriptioncheckout.exceptions.HTTP400Exception;
import com.rollingstone.prescriptioncheckout.exceptions.HTTP404Exception;
import com.rollingstone.prescriptioncheckout.service.LegacyPrescriptionCheckoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class LegacyPrescriptionCheckoutController extends AbstractController {

    private LegacyPrescriptionCheckoutService  prescriptionCheckoutService;

    public LegacyPrescriptionCheckoutController(LegacyPrescriptionCheckoutService prescriptionCheckoutService) {
        this.prescriptionCheckoutService = prescriptionCheckoutService;
    }

    /*---Add new PrescriptionCheckout---*/
    @PostMapping("/checkoutprescriptions")
    public ResponseEntity<?> createProduct(@RequestBody PrescriptionCheckout prescriptionCheckout) {
        try {
            PrescriptionCheckout savedPrescriptionCheckout = prescriptionCheckoutService.save(prescriptionCheckout);
            return ResponseEntity.ok().body("New PrescriptionCheckout has been saved with ID:" + savedPrescriptionCheckout.getID());
        }
        catch(Exception e) {
            throw new HTTP400Exception("The Request did not have proper data", new Date(), e);
        }

    }



}
