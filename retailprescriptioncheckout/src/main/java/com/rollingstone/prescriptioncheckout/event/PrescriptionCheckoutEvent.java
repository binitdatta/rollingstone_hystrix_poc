package com.rollingstone.prescriptioncheckout.event;

import com.rollingstone.prescriptioncheckout.domain.PrescriptionCheckout;
import org.springframework.context.ApplicationEvent;

public class PrescriptionCheckoutEvent extends ApplicationEvent {

    private String eventType;
    private PrescriptionCheckout prescriptionCheckout;
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public PrescriptionCheckout getPPrescriptionCheckout() {
        return prescriptionCheckout;
    }
    public void setPrescriptionCheckout(PrescriptionCheckout prescriptionCheckout) {
        this.prescriptionCheckout = prescriptionCheckout;
    }
    public PrescriptionCheckoutEvent(String eventType, PrescriptionCheckout prescriptionCheckout) {
        super(prescriptionCheckout);
        this.eventType = eventType;
        this.prescriptionCheckout = prescriptionCheckout;
    }

    @Override
    public String toString() {
        return "ProductEvent [eventType=" + eventType + ", prescriptionCheckout=" + prescriptionCheckout + "]";
    }
}
