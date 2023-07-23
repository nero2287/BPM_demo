package com.baiyu.bpm.bean.process;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * 流程角色表
 * @author lsx
 * @createDate 2023-07-23 21:26:25
 * @version 1.0
 */
@Data
public class ProcessNodeRole {
    /**
     * 主键
     */
    @TableId
    private int roleId;
    /**
     * 角色编码
     */
    private String roleCode;
    /**
     * 流程节点编码
     */
    private String nodeCode;
    /**
     * 操作权限：审核、审批、修改和查看
     */
    private int rolePermission;
}
