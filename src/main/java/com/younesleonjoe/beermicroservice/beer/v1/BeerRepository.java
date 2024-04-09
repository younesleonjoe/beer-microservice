package com.younesleonjoe.beermicroservice.beer.v1;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID> {}
