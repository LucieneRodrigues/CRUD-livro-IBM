package br.com.ibm.consulting.bootcamp.demospring.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Reserva {
    @Id
    @Email(message = "Informe um e-mail válido")
    private String email;

    @JsonProperty("data_inicio")
    private LocalDate dataInicio;

    @JsonProperty("data_fim")
    private LocalDate dataFinal;

    public Reserva() {

        }

        public Reserva( String email,  LocalDate dataInicio, LocalDate dataFinal) {
            this.email = email;
            this.dataInicio = dataInicio;
            this.dataFinal = dataFinal;

        }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
