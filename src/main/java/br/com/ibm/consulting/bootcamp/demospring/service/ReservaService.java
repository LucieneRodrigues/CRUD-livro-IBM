package br.com.ibm.consulting.bootcamp.demospring.service;

import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;
import br.com.ibm.consulting.bootcamp.demospring.domain.Reserva;
import br.com.ibm.consulting.bootcamp.demospring.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
    public class ReservaService {

        private final ReservaRepository repository;

        @Autowired
        public ReservaService(ReservaRepository repository) {
            this.repository = repository;
        }

        public Reserva criarReserva(Reserva reserva) {
            return reserva;
        }

        /*public Reserva criarReserva(String email, Livro livro, LocalDate dataInicio, LocalDate dataFinal) {
            Reserva reserva = new Reserva(email, livro, dataInicio, dataFinal);
            return repository.saveAndFlush(reserva);
        }*/

        public List<Livro> listar() {
            return repository.findAll();
        }

        public Livro obter(long id) {
            return repository.findById(id).orElse(null);
        }

        public void alterar(long id, Reserva novoLivro) {
            // Implemente a lógica para atualizar a reserva com o novo livro
        }

        public void excluir(long id) {
            repository.deleteById(id);
        }

    }

