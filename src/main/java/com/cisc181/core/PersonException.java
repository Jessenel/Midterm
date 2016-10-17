package com.cisc181.core;

import java.util.Date;

public class PersonException extends Exception{
	
	Person Person;
	
	public PersonException(Person Person){
		this.Person = Person;
	}

}