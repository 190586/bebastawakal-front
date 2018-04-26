package com.fwd.repository;

import com.fwd.domain.Pages;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "pages", path = "pages")
public abstract interface PageRepository extends CrudRepository<Pages, Long>, PagingAndSortingRepository<Pages, Long> {
    
    @RestResource(exported = false)
    public abstract List<Pages> findTop4ByTypeAndActiveOrderByOrdersAsc(String type, boolean active);
    
    @RestResource(exported = false)
    public abstract List<Pages> findTop1ByTypeAndActiveOrderByOrdersAsc(String type, boolean active);
    
    @RestResource(exported = false)
    public abstract List<Pages> findByTypeAndActiveOrderByOrdersAsc(String type, boolean active);
    
    @RestResource(path = "all", rel = "all")
    Page<Pages> findByTitleContainsIgnoreCaseOrTypeContainsIgnoreCaseOrBreadcrumbContainsIgnoreCaseOrCodeContainsIgnoreCase(@Param("q") String q1, @Param("q") String q2, @Param("q") String q3, @Param("q") String q4, Pageable pageable);
}
