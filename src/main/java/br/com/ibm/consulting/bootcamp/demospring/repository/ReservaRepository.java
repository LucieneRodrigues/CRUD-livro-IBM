package br.com.ibm.consulting.bootcamp.demospring.repository;
import br.com.ibm.consulting.bootcamp.demospring.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
}
