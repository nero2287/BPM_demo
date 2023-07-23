package com.baiyu.bpm.bean.process;

import lombok.Data;

/**
 * 流程角色-用户关联表
 * @author lsx
 * @createDate 2023-07-23 21:26:25
 * @version 1.0
 */
@Data
public class ProcessNodeRoleUser {
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 用户id
     */
    private int userId;
}
