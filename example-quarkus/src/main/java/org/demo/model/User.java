package org.demo.model;

import java.math.BigInteger;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Table(name = "\"user\"")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String username;

    @Column(unique = true, nullable=false)
    private String email;

    @Column(unique = true, nullable=false)
    private String password;

}
