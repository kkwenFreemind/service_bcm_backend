package com.fet.idtt.bcm.repository;

import com.fet.idtt.admin.model.User;
import com.fet.idtt.bcm.dto.FetUser;
import com.fet.idtt.bcm.model.FetCycleDuty;
import com.fet.idtt.bcm.model.FetCycleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kevin on 2024/6/11 下午9:16
 */
public interface FetCycleUserRespository  extends JpaRepository<FetCycleUser, Long> {




    @Query(value = "SELECT * " +
            "FROM fet_cycle_user",nativeQuery = true)
    List<FetCycleUser> getFetUser();

}
