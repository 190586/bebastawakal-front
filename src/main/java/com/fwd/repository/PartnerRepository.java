package com.fwd.repository;

import com.fwd.domain.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "partner", path = "partner")
public abstract interface PartnerRepository extends CrudRepository<Partner, Long>, PagingAndSortingRepository<Partner, Long> {

}
