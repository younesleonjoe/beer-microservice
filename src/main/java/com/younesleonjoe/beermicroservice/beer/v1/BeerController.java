package com.younesleonjoe.beermicroservice.beer.v1;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor
public class BeerController {
  private final BeerService beerService;

  @GetMapping
  public BeerPagedDTO findAll() {
    return beerService.findAll();
  }

  @GetMapping("/{id}")
  public BeerDTO findById(@PathVariable UUID id) {
    return beerService.findById(id);
  }

  @PostMapping
  public BeerDTO create(@Validated @RequestBody BeerDTO beerDTO) {
    return beerService.create(beerDTO);
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
