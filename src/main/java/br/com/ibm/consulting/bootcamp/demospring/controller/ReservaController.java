package br.com.ibm.consulting.bootcamp.demospring.controller;
import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;
import br.com.ibm.consulting.bootcamp.demospring.domain.Reserva;
import br.com.ibm.consulting.bootcamp.demospring.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//verificar se o path está correto
@RestController
@RequestMapping("/api/livros/:id/reservas")
public class ReservaController {

    @Autowired
    ReservaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva criar(@RequestBody Reserva reserva) {return service.criarReserva(reserva);

    }

    @GetMapping
    public List<Livro> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obter(@PathVariable long id) {
        var reserva = service.obter(id);
        if (reserva != null) {
            return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
        }
        return new ResponseEntity<Reserva>(reserva, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> atualizar(@RequestBody Reserva reserva, @PathVariable long id) {
        var reservaExistente = service.obter(id);
        if (reservaExistente != null) {
            service.alterar(id, reserva);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> excluir(@PathVariable long id) {
        var reservaExistente = service.obter(id);
        if (reservaExistente != null) {
            service.excluir(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


}
