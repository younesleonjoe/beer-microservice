package com.younesleonjoe.beermicroservice.beer.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {
  private List<BeerDTO> generateListOfEmptyBeers() {
    List<BeerDTO> beerDTOList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      beerDTOList.add(generateEmptyBeer(UUID.randomUUID()));
    }
    return beerDTOList;
  }

  private BeerDTO generateEmptyBeer(UUID id) {
    return BeerDTO.builder().id(id).build();
  }

  @Override
  public BeerPagedDTO findAll() {
    return new BeerPagedDTO(generateListOfEmptyBeers());
  }

  @Override
  public BeerDTO findById(UUID id) {
    return generateEmptyBeer(id);
  }

  @Override
  public BeerDTO create(BeerDTO beerDTO) {
    return beerDTO;
  }

  @Override
  public void update(UUID id, BeerDTO beerDTO) {}

  @Override
  public void delete(UUID id) {}
}
