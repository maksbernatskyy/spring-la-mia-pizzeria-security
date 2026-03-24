package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ingredienti")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il nome non può avere spazi vuoti")
    @NotNull(message = "Il nome è obbligatorio")
    private String nome;

    @ManyToMany(mappedBy = "ingredienti")
    private List<Pizza> pizze;

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }
}
