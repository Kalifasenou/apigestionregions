package com.api.apiregions_backend.Modeles;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String comment; 
    @ManyToOne
    private Region region;
    
}
