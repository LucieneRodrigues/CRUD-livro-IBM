package br.com.ibm.consulting.bootcamp.demospring.controller;
import br.com.ibm.consulting.bootcamp.demospring.domain.Reserva;
import br.com.ibm.consulting.bootcamp.demospring.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/livros/:id/reservas")
public class ReservaController {

    @Autowired
    ReservaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva criar(@RequestBody Reserva reserva) {return service.criarReserva(reserva);

    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Reserva> obter(@PathVariable String email) {
        var reserva = service.obter(email);
        if (reserva != null) {
            return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
        }
        return new ResponseEntity<Reserva>(reserva, HttpStatus.NOT_FOUND);
    }

    @PutMapping("{/email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> atualizar(@RequestBody Reserva reserva, @PathVariable String email) {
        var reservaExistente = service.obter(email);
        if (reservaExistente != null) {
            service.alterar(email, reserva);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }



    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> excluir(@PathVariable String email) {
        var reservaExistente = service.obter(email);
        if (reservaExistente != null) {
            service.excluir(email);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


}
