package com.mtemirdev.api;

import com.mtemirdev.dto.request.CompanyRequest;
import com.mtemirdev.dto.response.CompanyResponse;
import com.mtemirdev.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CompanyApi {

    private final CompanyService companyService;

    @PostMapping("/create_company")
    public String createCompany(@RequestBody CompanyRequest companyRequest) {
        companyService.createCompany(companyRequest);
        return "Company successfully created!";
    }

    @GetMapping("/get_all_companies")
    public List<CompanyResponse> getAllCompanies() {
        return companyService.findAllCompanies();
    }

    @GetMapping("/get_company/{id}")
    public CompanyResponse getById(@PathVariable Long id) {
        return companyService.findCompanyById(id);
    }

    @DeleteMapping("/delete_company/{id}")
    public String deleteById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return "Company successfully deleted!";
    }

    @PutMapping("/update_company/{id}")
    public String updateById(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        companyService.updateCompanyById(id, companyRequest);
        return "Company successfully updated!";
    }
}