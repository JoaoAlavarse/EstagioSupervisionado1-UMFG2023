package br.edu.umfg.estagio.repository.constructionEmployee;

import br.edu.umfg.estagio.entity.constructionEmployee.ConstructionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionEmployeeRepository extends JpaRepository<ConstructionEmployee, Long> {
}