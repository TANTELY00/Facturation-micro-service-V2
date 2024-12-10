package com.project.billing_service.repositories;

import com.project.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {
}
