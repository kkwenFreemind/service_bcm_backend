package com.fet.idtt.bcm.repository;

import com.fet.idtt.admin.model.UserRoles;
import com.fet.idtt.bcm.model.FetCycleDuty;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kevin on 2024/6/11 下午9:16
 */
@Repository
@Transactional
public interface FetCycleDutyRepository  extends JpaRepository<FetCycleDuty, Long> {

    @Query(value = "select * from fet_cycle_duty where user_id= :userId and user_prim ='Y' ",nativeQuery = true)
    public List<FetCycleDuty> findByUserId(String userId);
}
