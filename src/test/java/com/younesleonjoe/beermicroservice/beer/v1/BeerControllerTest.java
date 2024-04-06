package com.younesleonjoe.beermicroservice.beer.v1;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringJUnitConfig(BeerControllerTestConfig.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired MockMvc mockMvc;

  @Autowired BeerService beerService;

  @Autowired ObjectMapper objectMapper;

  String beerDTOJSON;
  BeerDTO beerDTO;

  BeerPagedDTO beerPagedDTO;

  @BeforeEach
  void setUp() throws JsonProcessingException {
    beerDTO =
        BeerDTO.builder()
            .beerName("beer1")
            .upc(1000L)
            .price(BigDecimal.TEN)
            .beerStyle(BeerStyleEnum.ALE)
            .quantityOnHand(10)
            .build();
    beerDTOJSON = objectMapper.writeValueAsString(beerDTO);
    beerPagedDTO = new BeerPagedDTO(Collections.singletonList(beerDTO));

    Mockito.when(beerService.findAll()).thenReturn(beerPagedDTO);
    Mockito.when(beerService.findById(Mockito.any(UUID.class))).thenReturn(beerDTO);
    Mockito.when(beerService.create(Mockito.any(BeerDTO.class))).thenReturn(beerDTO);
    Mockito.doNothing()
        .when(beerService)
        .update(Mockito.any(UUID.class), Mockito.any(BeerDTO.class));
    Mockito.doNothing().when(beerService).delete(Mockito.any(UUID.class));
  }

  @Test
  void findAll() {}

  @Test
  void findById() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/beers/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void create() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/beers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void update() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/api/v1/beers/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJSON))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  @Test
  void delete() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.delete("/api/v1/beers/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
  }
}
