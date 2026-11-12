package io.sol.laborderingoutbox.repository;

import io.sol.laborderingoutbox.entity.LabOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabOrderRepository extends JpaRepository<LabOrder, Long> {
}
