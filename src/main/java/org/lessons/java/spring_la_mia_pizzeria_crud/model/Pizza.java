package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "pizze")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Il nome è obbligatorio")
    @NotBlank(message = "Nome non deve essere vuoto")
    private String nome;

    private String descrizione;

    @Column(name="foto_url")
    private String fotoUrl;

    @NotNull(message = "Il prezzo è obbligatorio")
    @Positive(message = "Il prezzo deve essere maggiore di zero")
    private BigDecimal prezzo;

    @OneToMany(mappedBy = "pizza")
    private List<Offerta> offerta;

    @ManyToMany()
    @JoinTable(
        name = "pizza_ingrediente",
        joinColumns = @JoinColumn(name = "pizza_id"),
        inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredienti;

    // Getter and Setter

    // Id
    public Integer getId() {
        return this.id;
    }

    // Nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }

    // Descrizione
    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        if(descrizione != null && !descrizione.equals("")) {
            this.descrizione = descrizione;
        }
    } 

    // Foto
    public String getFotoUrl() {
        return this.fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        if(fotoUrl != null && !fotoUrl.equals("")) {
            this.fotoUrl = fotoUrl;
        }
    }

    // Prezzo
    public BigDecimal getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        if(prezzo.compareTo(BigDecimal.ZERO) > 0) {
            this.prezzo = prezzo;
        }
    }
}
