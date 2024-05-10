package yavirac.edu.ec.talleres.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yavirac.edu.ec.talleres.Model.Company;

public interface Companyrepository extends JpaRepository<Company, Long> {
    
}
