package com.baiyu.bpm.bean.process;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 流程池-流转中
 * @author lsx
 * @version 1.0
 * @createDate 2023/7/23 21:33
 * 只保留正在审核的流程
 */
@Data
public class ProcessOngoing {
    /**
     * 主键
     */
    @TableId
    private int processId;
    /**
     * 流程编码
     */
    private String processCode;
    /**
     *节点编码
     */
    private String nodeCode;
    /**
     *节点顺序步骤
     */
    private String nodeStep;
    /**
     * 分支编码
     */
    private String conditionCode;
    /**
     * 审核编号
     */
    private String formCode;
    /**
     * 表单编号
     */
    private String tableCode;
    /**
     * 当前待办人
     */
    private String assigneeName;
    /**
     * 节点属性类型：1.空节点跳过 2.空节点由当前操作人指定下一个节点审核人
     */
    private String nodeStepStatus;
//    /**
//     * 审核结果
//     */
//    private String nodeResult;
//    /**
//     * 审核时间
//     */
//    private String auditTime;
    /**
     * 流程到达该节点的起始时间
     */
    private String arrival_time;
    /**
     * 发起人信息
     */
    private int creatorId;
    /**
     * 发起时间
     */
    private String createTime;
}
