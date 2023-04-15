package com.mouflon.dto.response;

import lombok.Data;

@Data
public class CompanyResponse {

    private Long id;

    private String companyName;

    private String locatedCountry;
}
