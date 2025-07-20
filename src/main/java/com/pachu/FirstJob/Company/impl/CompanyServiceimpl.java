package com.pachu.FirstJob.Company.impl;

import com.pachu.FirstJob.Company.Company;
import com.pachu.FirstJob.Company.CompanyRepository;
import com.pachu.FirstJob.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceimpl implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyServiceimpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyId(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompanyById(Long id,Company updates) {
        if(companyRepository.existsById(id)){
            Company company = companyRepository.findById(id).get();
            company.setName(updates.getName());
            company.setDescription(updates.getDescription());
            company.setJobs(updates.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }
}
