package com.younesleonjoe.beermicroservice.beer.v1;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class BeerControllerTestConfig {

  @Bean
  public BeerService beerService() {
    return Mockito.mock(BeerService.class);
  }
}
