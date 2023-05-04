package com.zakur.salesapp.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class IngressDetailPK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "id_ingress", nullable = false)
    private Ingress ingress;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;
}
