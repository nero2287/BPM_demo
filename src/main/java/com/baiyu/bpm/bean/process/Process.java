package com.baiyu.bpm.bean.process;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 业务流程表
 * @author lsx
 * @createDate 2023-07-23 21:26:25
 * @version 1.0
 */

@Data
public class Process {
    /**
     * 主键
     */
    @TableId
    private int processId;
    /**
     * 流程名称
     */
    private String processName;
    /**
     * 流程编码
     */
    private String processCode;
    /**
     * 表单关联信息
     */
    private String processTableCode;
    /**
     * 流程状态：1.启用 2.停用 3.废弃
     */
    private int status;
    /**
     * 创建人信息
     */
    private int creatorUserId;
    /**
     * 创建时间
     */
    private String creatorTime;
    /**
     * 更新人
     */
    private int updaterId;
    /**
     * 更新时间
     */
    private String updateTime;
}
