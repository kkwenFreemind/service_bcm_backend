package com.fet.idtt.bcm.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kevin on 2024/6/11 下午9:26
 */
@Data
@Setter
@Getter
public class FetUser {
    private String cycle_date;
    private String user_id;
    private String group_id;
    private String english_name;
    private String chinese_name;
    private String user_prim;

}
