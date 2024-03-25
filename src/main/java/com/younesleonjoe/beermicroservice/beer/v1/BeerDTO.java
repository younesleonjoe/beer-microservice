package com.younesleonjoe.beermicroservice.beer.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {
	private UUID id;
	private Integer version;
	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
	private BigDecimal price;
	private Integer quantityOnHand;
}
