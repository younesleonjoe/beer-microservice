package com.younesleonjoe.beermicroservice.beer.v1;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;

public class BeerLoader implements CommandLineRunner {

  public static final String Beer_1_UPC = "0631234200036";
  public static final String Beer_2_UPC = "0631234200019";
  public static final String Beer_3_UPC = "0631234200020";
  private final BeerRepository beerRepository;

  public BeerLoader(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  @Override
  public void run(String... args) {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (beerRepository.count() > 0) return;
    beerRepository.save(
        Beer.builder()
            .id(UUID.randomUUID())
            .beerName("Mango Bobs")
            .version(new Random().nextInt())
            .beerStyle(BeerStyleEnum.IPA.toString())
            .quantityToBrew(200)
            .minOnHand(12)
            .upc(Beer_1_UPC)
            .price(new BigDecimal("123.45"))
            .build());

    beerRepository.save(
        Beer.builder()
            .id(UUID.randomUUID())
            .version(new Random().nextInt())
            .beerName("Galaxy Cat")
            .beerStyle(BeerStyleEnum.ALE.toString())
            .quantityToBrew(200)
            .minOnHand(12)
            .upc(Beer_2_UPC)
            .price(new BigDecimal("111.25"))
            .build());

    beerRepository.save(
        Beer.builder()
            .id(UUID.randomUUID())
            .version(new Random().nextInt())
            .beerName("Space Dog")
            .beerStyle(BeerStyleEnum.GOSE.toString())
            .quantityToBrew(200)
            .minOnHand(12)
            .upc(Beer_3_UPC)
            .price(new BigDecimal("111.25"))
            .build());

    System.out.println("Loaded Beers: " + beerRepository.count());
  }
}
