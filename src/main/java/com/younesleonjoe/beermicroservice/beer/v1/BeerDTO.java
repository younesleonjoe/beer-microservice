package com.younesleonjoe.beermicroservice.beer.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {
  @Null private UUID id;
  @Null private Integer version;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ'", shape = JsonFormat.Shape.STRING)
  @Null
  private OffsetDateTime createdAt;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ'", shape = JsonFormat.Shape.STRING)
  @Null
  private OffsetDateTime updatedAt;

  @NotBlank private String beerName;
  @NotNull private BeerStyleEnum beerStyle;
  @Positive @NotNull private Long upc;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @Positive
  @NotNull
  private BigDecimal price;

  private Integer quantityOnHand;
}
