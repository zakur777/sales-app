package com.zakur.salesapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(IngressDetailPK.class)
public class IngressDetail {

    @Id
    private Ingress ingress;

    @Id
    private Product product;

    @Column(nullable = false)
    private short quantity;

    @Column(columnDefinition = "decimal(6,2)",nullable = false)
    private short cost;

}
