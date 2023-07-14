package com.mouflon.dto.response;

import lombok.Data;

@Data
public class CompanyResponse {

    private Long companyId;
    private String companyName;
    private String locatedCountry;
}