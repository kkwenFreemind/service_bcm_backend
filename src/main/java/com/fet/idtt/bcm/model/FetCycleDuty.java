package com.fet.idtt.bcm.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

/**
 * Created by kevin on 2024/6/11 下午9:06
 */
@Entity
@Data
@Table(name = "fet_cycle_duty")
public class FetCycleDuty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date cycle_date;
    private String user_id;
    private String group_id;
    private String user_prim;
}
