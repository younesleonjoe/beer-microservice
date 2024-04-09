package com.younesleonjoe.beermicroservice.beer.v1;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/beers")
@RequiredArgsConstructor
public class BeerController {
  private final BeerService beerService;

  @GetMapping
  public BeerPagedDTO findAll() {
    return beerService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<BeerDTO> findById(@PathVariable UUID id) {
    return new ResponseEntity<>(beerService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<BeerDTO> create(@Validated @RequestBody BeerDTO beerDTO) {

    return new ResponseEntity<>(beerService.create(beerDTO), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable UUID id, @Validated @RequestBody BeerDTO beerDTO) {
    beerService.update(id, beerDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    beerService.delete(id);
  }
}
