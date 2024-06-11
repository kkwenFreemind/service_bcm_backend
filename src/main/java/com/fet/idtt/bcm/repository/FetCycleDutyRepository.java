package com.fet.idtt.bcm.repository;

import com.fet.idtt.admin.model.UserRoles;
import com.fet.idtt.bcm.model.FetCycleDuty;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by kevin on 2024/6/11 下午9:16
 */
@Repository
@Transactional
public interface FetCycleDutyRepository  extends JpaRepository<FetCycleDuty, Long> {
}
