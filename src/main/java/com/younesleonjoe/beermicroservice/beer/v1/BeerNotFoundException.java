package com.younesleonjoe.beermicroservice.beer.v1;

import java.util.UUID;

public class BeerNotFoundException extends RuntimeException {
  public BeerNotFoundException(UUID id) {
    super(String.format("Beer with id %s not found", id));
  }
}
