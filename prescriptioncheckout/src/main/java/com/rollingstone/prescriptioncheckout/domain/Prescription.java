package com.rollingstone.prescriptioncheckout.domain;

import java.util.Objects;

public class Prescription {

    private long prescriptionID;

    private String drugName;

    private String drugDosage;

    private String numberOfTimesPerDay;

    private boolean generic;

    private String manufacturerName;

    public long getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(long prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage;
    }

    public String getNumberOfTimesPerDay() {
        return numberOfTimesPerDay;
    }

    public void setNumberOfTimesPerDay(String numberOfTimesPerDay) {
        this.numberOfTimesPerDay = numberOfTimesPerDay;
    }

    public boolean isGeneric() {
        return generic;
    }

    public void setGeneric(boolean generic) {
        this.generic = generic;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Prescription(long prescriptionID, String drugName, String drugDosage, String numberOfTimesPerDay, boolean generic, String manufacturerName) {
        this.prescriptionID = prescriptionID;
        this.drugName = drugName;
        this.drugDosage = drugDosage;
        this.numberOfTimesPerDay = numberOfTimesPerDay;
        this.generic = generic;
        this.manufacturerName = manufacturerName;
    }

    public Prescription() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return prescriptionID == that.prescriptionID &&
                generic == that.generic &&
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(drugDosage, that.drugDosage) &&
                Objects.equals(numberOfTimesPerDay, that.numberOfTimesPerDay) &&
                Objects.equals(manufacturerName, that.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionID, drugName, drugDosage, numberOfTimesPerDay, generic, manufacturerName);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID=" + prescriptionID +
                ", drugName='" + drugName + '\'' +
                ", drugDosage='" + drugDosage + '\'' +
                ", numberOfTimesPerDay='" + numberOfTimesPerDay + '\'' +
                ", generic=" + generic +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}
