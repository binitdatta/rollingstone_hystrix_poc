package com.rollingstone.prescriptioncheckout.listener;

import com.rollingstone.prescriptioncheckout.event.PrescriptionCheckoutEvent;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;

@Component
public class PrescriptionCheckoutEventListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void onApplicationEvent(PrescriptionCheckoutEvent prescriptionCheckoutEvent) {
        log.info("Received PrescriptionCheckoutEvent Event : "+prescriptionCheckoutEvent.getEventType());
        log.info("Received PrescriptionCheckoutEvent From PrescriptionCheckoutEvent Event :"+prescriptionCheckoutEvent.getPPrescriptionCheckout().toString());
    }
}
