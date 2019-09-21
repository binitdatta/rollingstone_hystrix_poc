package com.rollingstone.prescriptioncheckout.domain;


import java.util.List;

public class PrescriptionCheckout {

    private long ID;

    Customer customer;


    List<Prescription> prescriptions;

    PharmacyStore store;

    double totalCost;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public PharmacyStore getStore() {
        return store;
    }

    public void setStore(PharmacyStore store) {
        this.store = store;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public PrescriptionCheckout(Customer customer, List<Prescription> prescriptions, PharmacyStore store, double totalCost) {
        this.customer = customer;
        this.prescriptions = prescriptions;
        this.store = store;
        this.totalCost = totalCost;
    }

    public PrescriptionCheckout() {
    }

    @Override
    public String toString() {
        return "PrescriptionCheckout{" +
                "customer=" + customer +
                ", prescriptions=" + prescriptions +
                ", store=" + store +
                ", totalCost=" + totalCost +
                '}';
    }
}
