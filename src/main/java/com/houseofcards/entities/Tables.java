package com.houseofcards.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tables {
	
	private Set<String> names = new HashSet<>();
	
	
	public Tables() {
		names.add("Products");
		names.add("Sales");
		names.add("Users");
		names.add("Events");
	}
	

	public Set<String> getNames() {
		return names;
	}

	public void setNames(Set<String> names) {
		this.names = names;
	}

}
