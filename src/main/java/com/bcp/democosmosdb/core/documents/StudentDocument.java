package com.bcp.democosmosdb.core.documents;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

@Container(containerName = "StudentDocumentHM")
public class StudentDocument {
    @Id
    @GeneratedValue
    private String id;
    private String firstname;
    @PartitionKey
    private String lastname;
    private AddressDocument address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public AddressDocument getAddress() {
        return address;
    }

    public void setAddress(AddressDocument address) {
        this.address = address;
    }
}
