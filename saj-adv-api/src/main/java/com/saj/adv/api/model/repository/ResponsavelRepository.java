package com.saj.adv.api.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.saj.adv.api.model.entity.Responsavel;

@RepositoryRestResource(collectionResourceRel = "responsavel", path = "responsavel")
public interface ResponsavelRepository extends MongoRepository<Responsavel, Long> {

}
