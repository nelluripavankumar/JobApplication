package com.pachu.FirstJob.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    void createCompany(Company company);
    Company findCompanyById(Long id);
    boolean deleteCompanyId(Long id);
    boolean updateCompanyById(Long id,Company updates);
}
