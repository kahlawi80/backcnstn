package com.cnstn.entities;

import javax.persistence.*;

@DiscriminatorValue("scan") 

public class Scanere extends Materiels{
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private type3 enum3;

}
