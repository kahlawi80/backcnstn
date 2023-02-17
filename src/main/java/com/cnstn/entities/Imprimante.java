package com.cnstn.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@DiscriminatorValue("imp")
@Entity 
@AllArgsConstructor
@NoArgsConstructor
public class Imprimante extends Materiels {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id ;
	private String nom ;
	private  type1 enum1 ;

}
