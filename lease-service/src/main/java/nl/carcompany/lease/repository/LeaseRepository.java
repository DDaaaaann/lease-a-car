package nl.carcompany.lease.repository;

import nl.carcompany.lease.entity.LeaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends JpaRepository<LeaseEntity, Long> {

}
