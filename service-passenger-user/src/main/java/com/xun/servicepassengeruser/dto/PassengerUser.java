package com.xun.servicepassengeruser.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/918:48
 */
@Data
public class PassengerUser {
    private Long id;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private String passengerPhone;
    private String passengerName;
    private byte passengerGender;
    private byte state;
}
