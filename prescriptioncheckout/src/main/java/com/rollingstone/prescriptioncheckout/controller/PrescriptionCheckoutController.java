package com.rollingstone.prescriptioncheckout.controller;

import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;
import com.rollingstone.prescriptioncheckout.event.PrescriptionCheckoutEvent;
import com.rollingstone.prescriptioncheckout.exceptions.HTTP400Exception;
import com.rollingstone.prescriptioncheckout.exceptions.HTTP404Exception;
import com.rollingstone.prescriptioncheckout.service.PrescriptionCheckoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PrescriptionCheckoutController extends AbstractController {

    private PrescriptionCheckoutService  prescriptionCheckoutService;

    public PrescriptionCheckoutController(PrescriptionCheckoutService prescriptionCheckoutService) {
        this.prescriptionCheckoutService = prescriptionCheckoutService;
    }

    /*---Add new PrescriptionCheckout---*/
    @PostMapping("/checkoutprescriptions")
    public ResponseEntity<?> createProduct(@RequestBody PrescriptionCheckout prescriptionCheckout) {
        try {
            PrescriptionCheckout savedPrescriptionCheckout = prescriptionCheckoutService.save(prescriptionCheckout);
            PrescriptionCheckoutEvent prescriptionCheckoutCreatedEvent = new PrescriptionCheckoutEvent("One PrescriptionCheckoutEvent is created", savedPrescriptionCheckout);
            eventPublisher.publishEvent(prescriptionCheckoutCreatedEvent);
            return ResponseEntity.ok().body("New PrescriptionCheckout has been saved with ID:" + savedPrescriptionCheckout.getID());
        }
        catch(Exception e) {
            throw new HTTP400Exception("The Request did not have proper data", new Date(), e);
        }

    }

    /*---Get a PrescriptionCheckout by id---*/
    @GetMapping("/checkoutprescription/{id}")
    public ResponseEntity<PrescriptionCheckout> getPrescriptionCheckout(@PathVariable("id") String id) {
        try {
            PrescriptionCheckout returnedPrescriptionCheckout = prescriptionCheckoutService.get(id);

            PrescriptionCheckoutEvent prescriptionCheckoutEventGetEvent = new PrescriptionCheckoutEvent("One returnedPrescriptionCheckout is retrieved", returnedPrescriptionCheckout);
            eventPublisher.publishEvent(prescriptionCheckoutEventGetEvent);
            return ResponseEntity.ok().body(returnedPrescriptionCheckout);
        }
        catch(Exception e) {
            throw new HTTP404Exception("The Requested Product was not found", new Date(), e);
        }
    }

    /*---get all checkoutprescriptions---*/
    @GetMapping("/checkoutprescriptions")
    public @ResponseBody List<PrescriptionCheckout> getPrescriptionCheckoutByPage(
            @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
            @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
        List<PrescriptionCheckout> prescriptions = prescriptionCheckoutService.getPrescriptionCheckouts();
        return prescriptions;
    }

    /*---Update a checkoutprescriptions by id---*/
    @PutMapping("/checkoutprescriptions/{id}")
    public ResponseEntity<?> updateCheckoutPrescription(@PathVariable("id") String id, @RequestBody PrescriptionCheckout prescriptionCheckout)  {
        try {
            checkResourceFound(this.prescriptionCheckoutService.get(id));
            prescriptionCheckoutService.update(id, prescriptionCheckout);
            return ResponseEntity.ok().body("PrescriptionCheckout has been updated successfully.");
        }
        catch(Exception e) {
            throw new HTTP404Exception("The Requested Product was not found", new Date(), e);
        }

    }

    /*---Delete a checkoutprescriptions by id---*/
    @DeleteMapping("/checkoutprescriptions/{id}")
    public ResponseEntity<?> deleteCheckoutPrescription(@PathVariable("id") String id) {
        checkResourceFound(this.prescriptionCheckoutService.get(id));
        prescriptionCheckoutService.delete(id);
        return ResponseEntity.ok().body("PrescriptionCheckout has been deleted successfully.");
    }

}
