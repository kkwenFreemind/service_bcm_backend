package com.fet.idtt.bcm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Created by kevin on 2024/6/11 下午9:06
 */
@Entity
@Data
@Table(name = "fet_cycle_user")
public class FetCycleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private Date creation_date;
    private String english_name;
    private String chinese_name;
    private String mobile_phone;
    private String home_phone;
    private String email;
    private String department;
    private String group_id;
    private String role;
    private String role_id;
    private String vaild;
    private String remark;
}
