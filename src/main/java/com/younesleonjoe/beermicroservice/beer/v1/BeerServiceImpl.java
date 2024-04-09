package com.younesleonjoe.beermicroservice.beer.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

  private final BeerRepository beerRepository;
  private final BeerMapper beerMapper;

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
    // return generateEmptyBeer(id);
    return beerMapper.beerToBeerDTO(
        beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id)));
  }

  @Override
  public BeerDTO create(BeerDTO beerDTO) {
    // return beerDTO;
    return beerMapper.beerToBeerDTO(beerRepository.save(beerMapper.beerDTOToBeer(beerDTO)));
  }

  @Override
  public void update(UUID id, BeerDTO beerDTO) {
    beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
    beerRepository.save(beerMapper.beerDTOToBeer(beerDTO));
  }

  @Override
  public void delete(UUID id) {}
}
