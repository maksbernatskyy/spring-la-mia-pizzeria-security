package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "offerta")
public class Offerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il titolo non può avere spazi vuoti")
    @NotNull(message = "L'offerta deve avere un titolo")
    private String titolo;

    @NotNull(message = "L'offerta deve avere una data di inizio")
    private LocalDate dateStart;

    @NotNull(message = "L'offerta deve avere una data di fine")
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    public Integer getId() {
        return this.id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        if(titolo != null && !titolo.equals("")) {
            this.titolo = titolo;
        }
    }

    
}
