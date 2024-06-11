package com.fet.idtt.bcm.controller;

import com.fet.idtt.admin.model.ApiEvents;
import com.fet.idtt.admin.model.Organization;
import com.fet.idtt.admin.model.User;
import com.fet.idtt.admin.payload.request.LoginRequest;
import com.fet.idtt.admin.repository.ApiEventRepository;
import com.fet.idtt.admin.security.service.UserDetailsImpl;
import com.fet.idtt.bcm.dto.FetUser;
import com.fet.idtt.bcm.dto.FetUserRequest;
import com.fet.idtt.bcm.model.FetCycleDuty;
import com.fet.idtt.bcm.model.FetCycleUser;
import com.fet.idtt.bcm.repository.FetCycleDutyRepository;
import com.fet.idtt.bcm.repository.FetCycleUserRespository;
import com.fet.idtt.common.api.CommonResult;
import com.fet.idtt.utils.IpUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by kevin on 2024/6/11 下午9:30
 */
@Slf4j
@RestController
@RequestMapping("/fet")
@Tag(name = "FET Controller")
public class FetController {

    @Autowired
    FetCycleUserRespository fetCycleUserRespository;

    @Autowired
    FetCycleDutyRepository fetCycleDutyRepository;

    @Autowired
    ApiEventRepository apiEventRepository;

    @RequestMapping(value = "/getFetUser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult authenticateUser(
            HttpServletRequest request,
            @RequestHeader(value = "User-Agent") String userAgent,
            @Valid @RequestBody FetUserRequest fetUserRequest) {


        StopWatch sw = new StopWatch();
        sw.start("Login Start");
        String ipAddress = IpUtil.getIpAddr(request);

        try {

            List<FetCycleUser> fetUserList = fetCycleUserRespository.findAll();
            log.info("===>"+fetUserList.size());
            List<FetUser> fetUsersDto = new ArrayList<>();
            for(FetCycleUser fetCycleUser : fetUserList){
                FetUser fetUser = new FetUser();
                List<FetCycleDuty> fetCycleDuty = fetCycleDutyRepository.findByUserId(fetCycleUser.getUser_id());

                fetUser.setChinese_name(fetCycleUser.getChinese_name());
                fetUser.setEnglish_name(fetCycleUser.getEnglish_name());
                fetUser.setUser_id(fetCycleUser.getUser_id());
                fetUser.setGroup_id(fetCycleDuty.get(0).getGroup_id());
                fetUser.setCycle_date(fetCycleDuty.get(0).getCycle_date().toString());
                fetUser.setUser_prim(fetCycleDuty.get(0).getUser_prim());
                fetUsersDto.add(fetUser);

            }
            sw.stop();
            //ApiEvents apiEvents = new ApiEvents(user.getId(), ipAddress, request.getMethod(), user.getUsername(), request.getRequestURL().toString(), 1, "success", userAgent, 1, sw.getTotalTimeMillis());
            //apiEventRepository.save(apiEvents);

            return CommonResult.success(fetUsersDto);

        } catch (Exception exception) {

            log.info("login exception=>" + exception.toString());
            sw.stop();

            //ApiEvents apiEvents = new ApiEvents(999L, ipAddress, request.getMethod(), loginRequest.getUsername(), request.getRequestURL().toString(), 0, "failed" + exception.toString(), userAgent, 1, sw.getTotalTimeMillis());
            //apiEventRepository.save(apiEvents);

            return CommonResult.unauthorized(null);
        }
    }


}
