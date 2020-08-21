package com.tm.travels.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author tangmin
 * @Date 2020/8/21 14:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result {
    private Boolean state = true;
    private String message;
    private String userId;
}

