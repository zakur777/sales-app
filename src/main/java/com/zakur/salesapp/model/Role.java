package com.zakur.salesapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Role {

    @EqualsAndHashCode.Include
    @Id
    private Integer idRole;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean enabled;

}
