package br.com.ibm.consulting.bootcamp.demospring.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @Email(message = "Informe um e-mail válido")
    private String email;

    @ManyToOne
    @JoinColumn(name = "livro_id") // Nome da coluna que faz referência ao livro
    private long livroId;;

    @JsonProperty("data_inicio")
    private LocalDate dataInicio;


    @JsonProperty("data_fim")
    private LocalDate dataFinal;

    public Reserva() {

        }

        public Reserva(long idReserva, String email, LocalDate dataInicio, LocalDate dataFinal) {
            this.idReserva = idReserva;
            this.email = email;
            this.dataInicio = dataInicio;
            this.dataFinal = dataFinal;
            this.livroId = livroId;
        }

    public Reserva(String email, long livroId, LocalDate dataInicio, LocalDate dataFinal) {
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long id) {
        this.idReserva = idReserva;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getLivroId() {
        return livroId;
    }

    public void setLivroId(long livroId) {
        this.livroId = livroId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
}
