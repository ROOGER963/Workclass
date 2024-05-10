package yavirac.edu.ec.talleres.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yavirac.edu.ec.talleres.Model.Company;
import yavirac.edu.ec.talleres.Repository.Companyrepository;

@Service
public class CompanyService {
    @Autowired
    private Companyrepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company updatedCompany) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        existingCompany.setRuc(updatedCompany.getRuc());
        existingCompany.setName(updatedCompany.getName());
        existingCompany.setDescription(updatedCompany.getDescription());
        return companyRepository.save(existingCompany);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
