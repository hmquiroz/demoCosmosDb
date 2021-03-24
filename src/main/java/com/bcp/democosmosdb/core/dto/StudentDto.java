package com.bcp.democosmosdb.core.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String id;
    private String firstname;
    private String lastname;
    private AddressDto address;
}
