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


        public List<Reserva> listar() {
            return repository.findAll();
        }

        public Reserva obter(String email) {
            return repository.getReferenceById(email);
        }

        public void alterar(String email, Reserva novaReserva) {
            var alterada =new Reserva (email, novaReserva.getDataInicio(),novaReserva.getDataFinal());
        }

        public void excluir(String email) {
            repository.deleteById(email);
        }

    }

