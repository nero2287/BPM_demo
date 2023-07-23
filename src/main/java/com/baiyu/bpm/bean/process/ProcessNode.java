package com.baiyu.bpm.bean.process;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 流程节点
 * @author lsx
 * @createDate 2023-07-23 21:26:25
 * @version 1.0
 */
@Data
public class ProcessNode {
    /**
     * 主键
     */
    @TableId
    private int processNodeId;
    /**
     * 流程编码
     */
    private String processCode;
    /**
     * 流程节点名称
     */
    private String nodeName;
    /**
     * 流程节点编码
     */
    private String nodeCode;
    /**
     * 流程节点顺序
     */
    private int nodeStep;
    /**
     * 节点顺序属性：1.空节点跳过 2.空节点由当前操作人指定下一个节点审核人
     */
    private int nodeStepStatus;
    /**
     * 节点执行方式：1.全部执行 2.有竞争执行 3.由上一个操作人指定下一个节点审核人
     */
    private int nodeStatus;
    /**
     * 节点属性：发起、审核、审批、知会、通知
     */
    private String nodeFunction;
    /**
     * 分支编码
     */
    private String conditionCode;
    /**
     * 状态：1.启用 2.停用 3.删除
     */
    private String status;
    /**
     * 创建人id
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
