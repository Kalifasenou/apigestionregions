package com.api.apiregions_backend.Modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String password;
    private String role;
	public Object getPassword() {
		return null;
	}
    public String getUsername() {
        return null;
    }
    public Object getRole() {
        return null;
    }

}


