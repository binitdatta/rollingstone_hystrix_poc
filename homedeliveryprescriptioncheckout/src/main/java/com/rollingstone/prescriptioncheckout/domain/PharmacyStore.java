package com.rollingstone.prescriptioncheckout.domain;

import java.util.Objects;

public class PharmacyStore {

    Address storeAddress;

    private String contactPhoneNumber;

    private String managerName;

    public Address getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(Address storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public PharmacyStore(Address storeAddress, String contactPhoneNumber, String managerName) {
        this.storeAddress = storeAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.managerName = managerName;
    }

    public PharmacyStore() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyStore that = (PharmacyStore) o;
        return Objects.equals(storeAddress, that.storeAddress) &&
                Objects.equals(contactPhoneNumber, that.contactPhoneNumber) &&
                Objects.equals(managerName, that.managerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeAddress, contactPhoneNumber, managerName);
    }

    @Override
    public String toString() {
        return "PharmacyStore{" +
                "storeAddress=" + storeAddress +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
