package com.rollingstone.prescriptioncheckout.domain;

import java.util.Objects;

public class Doctor {

    long doctorID;

    String firstName;

    String lastName;

    Address address;

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Doctor(long doctorID, String firstName, String lastName, Address address) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Doctor() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorID == doctor.doctorID &&
                Objects.equals(firstName, doctor.firstName) &&
                Objects.equals(lastName, doctor.lastName) &&
                Objects.equals(address, doctor.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorID, firstName, lastName, address);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
