package com.mtemirdev.service;

import com.mtemirdev.dto.request.CompanyRequest;
import com.mtemirdev.dto.response.CompanyResponse;
import com.mtemirdev.model.Company;
import com.mtemirdev.exception.CustomRuntimeException;
import com.mtemirdev.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        Company company = modelMapper.map(companyRequest, Company.class);
        company = companyRepository.save(company);
        return modelMapper.map(company, CompanyResponse.class);
    }

    public CompanyResponse findCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Company not found with id: " + id));
        return modelMapper.map(company, CompanyResponse.class);
    }

    public List<CompanyResponse> findAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteCompanyById(Long id) {
        boolean exists = companyRepository.existsById(id);
        if (!exists) {
            throw new CustomRuntimeException("Company with id : " + id + "doesn't exist.");
        }
        companyRepository.deleteById(id);
    }

    public CompanyResponse updateCompanyById(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Company not found with id " + id));
        modelMapper.map(companyRequest, company);
        company = companyRepository.save(company);
        return modelMapper.map(company, CompanyResponse.class);
    }
}