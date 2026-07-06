package com.hm.mes_final_260106.repository;

import com.hm.mes_final_260106.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
    List<WorkOrder> findAllByOrderByIdDesc();
    Optional<WorkOrder> findFirstByStatusOrderByIdAsc(String status);
    Optional<WorkOrder> findByStatusAndAssignedMachineId(String status, String machineId);
}
