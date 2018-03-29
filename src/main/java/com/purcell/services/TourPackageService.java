package com.purcell.services;

import com.purcell.domain.TourPackage;
import com.purcell.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {
        // make sure one doesn't exist no dups
        if (!tourPackageRepository.exists(code)) {
            tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }

    // look up all
    public Iterable<TourPackage> lookup() {
        return tourPackageRepository.findAll();
    }

    // how many in db.
    public long total() {
        return tourPackageRepository.count();
    }
}


