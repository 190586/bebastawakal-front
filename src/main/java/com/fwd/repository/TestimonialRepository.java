package com.fwd.repository;

import com.fwd.domain.Pages;
import com.fwd.domain.Testimonial;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "testimonials", path = "testimonials")
public abstract interface TestimonialRepository extends CrudRepository<Testimonial, Long>, PagingAndSortingRepository<Testimonial, Long> {

    public abstract List<Testimonial> findTop8ByApprovalOrPrimeOrderByDatetimeDesc(boolean approval, boolean primary);

    @RestResource(path = "approval", rel = "approval")
    Page<Testimonial> findByApproval(@Param("q") boolean approval, Pageable pageable);
    
    @RestResource(path = "all", rel = "all")
    Page<Testimonial> findByNameContainsIgnoreCaseOrOccupationContainsIgnoreCaseOrContentContainsIgnoreCaseOrWebsiteContainsIgnoreCase(@Param("q") String q1, @Param("q") String q2, @Param("q") String q3, @Param("q") String q4, Pageable pageable);

}
