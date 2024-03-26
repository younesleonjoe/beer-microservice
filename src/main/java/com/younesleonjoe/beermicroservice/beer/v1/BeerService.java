package com.younesleonjoe.beermicroservice.beer.v1;

import java.util.UUID;

public interface BeerService {
	BeerPagedDTO findAll();
	BeerDTO findById(UUID id);
	BeerDTO create(BeerDTO beerDTO);
	void update(UUID id, BeerDTO beerDTO);
	void delete(UUID id);
}
