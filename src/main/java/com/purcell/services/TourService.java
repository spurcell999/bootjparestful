package com.purcell.services;

import com.purcell.domain.Difficulty;
import com.purcell.domain.Region;
import com.purcell.domain.Tour;
import com.purcell.domain.TourPackage;
import com.purcell.repo.TourPackageRepository;
import com.purcell.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TourService {

    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    // method to create new tour
    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region) {
        // need tour repository package find by the <code></code>
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if (tourPackage == null) {
            throw new RuntimeException("Tour package does not exist. " + tourPackageName);
        }
        return tourRepository.save( new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    // look up tour
    public Iterable<Tour> lookup() {
        return tourRepository.findAll();
    }

    public long total() {
        return tourRepository.count();
    }
}

