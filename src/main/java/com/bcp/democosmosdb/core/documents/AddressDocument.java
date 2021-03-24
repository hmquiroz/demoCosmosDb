package com.bcp.democosmosdb.core.documents;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Container(containerName = "AddressDocumentHM")
public class AddressDocument {
    private Integer number;
    private String street;
    private String district;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
