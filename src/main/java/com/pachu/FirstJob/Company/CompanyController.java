package com.pachu.FirstJob.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/companies")
@RestController
public class CompanyController {
    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> findall(){
        return companyService.findAll();
    }
    @PostMapping
    public ResponseEntity<String> crateCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created Succesfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id){
        Company c = companyService.findCompanyById(id);
        if(c != null)
            return new ResponseEntity<>(c,HttpStatus.OK);
        return  null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean f = companyService.deleteCompanyId(id);
        if(f)
            return new ResponseEntity<>("Deleted Succesfully",HttpStatus.ACCEPTED);
        return new ResponseEntity<>("Id Not Found in Entity",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id,@RequestBody Company company){
        boolean f =companyService.updateCompanyById(id,company);
        if(f)
            return new ResponseEntity<>("Deleted Succesfully",HttpStatus.ACCEPTED);
        return new ResponseEntity<>("Id Not Found in Entity",HttpStatus.NOT_FOUND);
    }

}

