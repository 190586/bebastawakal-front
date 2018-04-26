package com.fwd.repository;

import com.fwd.domain.Menu;
import com.fwd.domain.Profile;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "profiles", path = "profiles")
public abstract interface ProfileRepository extends CrudRepository<Profile, Long>, PagingAndSortingRepository<Profile, Long> {

    public abstract List<Profile> findTop1ByPrimeOrderByIdProfileAsc(boolean prime);
    
    @RestResource(path = "all", rel = "all")
    Page<Menu> findByCompanyNameContainsIgnoreCaseOrAddress1ContainsIgnoreCaseOrAddress2ContainsIgnoreCaseOrHotlineContainsIgnoreCaseOrEmailContainsIgnoreCaseOrFooterDescriptionContainsIgnoreCaseOrInstagramLinkContainsIgnoreCaseOrYoutubeLinkContainsIgnoreCaseOrFacebookLinkContainsIgnoreCaseOrTwitterLinkContainsIgnoreCase(@Param("q") String q1, @Param("q") String q2, @Param("q") String q3, @Param("q") String q4, @Param("q") String q5, @Param("q") String q6, @Param("q") String q7, @Param("q") String q8, @Param("q") String q9, @Param("q") String q10, Pageable pageable);
    
}
