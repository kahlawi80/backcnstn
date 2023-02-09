package com.cnstn.tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
	@Id @GeneratedValue
	private long id;
	private String nom;
	@ManyToOne
	private List<Produit> produits= new ArrayList<Produit>();

}
