package com.example.accessingdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name="modeleName",
                column = @Column(name="nom_du_modele")
        ),
        @AttributeOverride(
                name="prix",
                column = @Column(name="prix_du_modele")
        )
})
public class Modele {

    private String modeleName;
    private float prix;
}
