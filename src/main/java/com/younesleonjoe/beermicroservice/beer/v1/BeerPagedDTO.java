package com.younesleonjoe.beermicroservice.beer.v1;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPagedDTO extends PageImpl<BeerDTO> {
	public BeerPagedDTO(List<BeerDTO> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public BeerPagedDTO(List<BeerDTO> content) {
		super(content);
	}
}
