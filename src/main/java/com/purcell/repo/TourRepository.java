package com.purcell.repo;

import com.purcell.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {

    @Override
    @RestResource(exported=false)
    <S extends Tour> S save(S s);

    @Override
    @RestResource(exported=false)
    <S extends Tour> Iterable<S> save(Iterable<S> iterable);

    @Override
    @RestResource(exported=false)
    void delete(Integer integer);

    @Override
    @RestResource(exported=false)
    void delete(Tour tour);

    @Override
    @RestResource(exported=false)
    void delete(Iterable<? extends Tour> iterable);

    @Override
    @RestResource(exported=false)
    void deleteAll();

    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
}




