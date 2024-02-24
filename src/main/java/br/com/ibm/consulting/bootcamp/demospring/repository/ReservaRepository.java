package br.com.ibm.consulting.bootcamp.demospring.repository;

import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Livro, Long> {
}
