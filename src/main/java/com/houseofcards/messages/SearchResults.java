package com.houseofcards.messages;

import java.util.ArrayList;
import java.util.List;

import com.houseofcards.entities.ProductResult;
import com.houseofcards.entities.generated.Products;

public class SearchResults {

	private List<ProductResult> results = new ArrayList<>();
	
	
	public SearchResults() {};
	
	public SearchResults(List<ProductResult> p) {
		results = p;
	}
	
	
	public void addResult(ProductResult result) {
		results.add(result);
	}

	public List<ProductResult> getResults() {
		return results;
	}

	public void setResults(List<ProductResult> results) {
		this.results = results;
	}
	
}
