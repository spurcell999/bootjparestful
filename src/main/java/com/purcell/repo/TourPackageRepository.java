package com.purcell.repo;

import com.purcell.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "packages", path="packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    @Override
    @RestResource(exported=false)
    <S extends TourPackage> S save(S s);

    @Override
    @RestResource(exported=false)
    <S extends TourPackage> Iterable<S> save(Iterable<S> iterable);

    @Override
    @RestResource(exported=false)
    void delete(String s);

    @Override
    @RestResource(exported=false)
    void delete(TourPackage tourPackage);

    @Override
    @RestResource(exported=false)
    void delete(Iterable<? extends TourPackage> iterable);

    @Override
    @RestResource(exported=false)
    void deleteAll();

    TourPackage findByName(@Param("name")String name);
}
