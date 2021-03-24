package com.bcp.democosmosdb.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class AddressDto {
    private Integer number;
    private String street;
    private String district;
}
