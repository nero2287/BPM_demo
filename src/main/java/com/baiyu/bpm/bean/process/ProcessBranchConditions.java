package com.baiyu.bpm.bean.process;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 流程分支条件
 * @author lsx
 * @createDate 2023-07-23 21:26:25
 * @version 1.0
 */
@Data
public class ProcessBranchConditions {
    /**
     * 主键
     */
    @TableId
    private int conditionId;
    /**
     * 流程编码
     */
    private String processCode;
    /**
     * 分支流程节点编码
     */
    private String nodeCode;
    /**
     * 流程节点顺序
     */
    private int nodeStep;
    /**
     * 角色编码
     */
    private String roleCode;
    /**
     * 分支编码
     */
    private String conditionCode;
//    /**
//     * 分支条件字段表编码
//     */
//    private String conditionTableCode;
//    /**
//     * 分支条件字段编码
//     */
//    private String conditionColumnCode;
    /**
     * 需要比较的值
     */
    private String conditionCompareBeforeValue;
    /**
     * 比较条件
     */
    private String conditionCompare;
    /**
     * 比较的目标值
     */
    private String conditionCompareTargetValue;
    /**
     * 比较公式
     */
    private String conditionCompareFormula;
    /**
     * 状态：1.启用 2.停用 3.删除
     */
    private int status;
    /**
     * 创建人信息
     */
    private int creatorId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人信息
     */
    private int updaterId;
    /**
     * 更新时间
     */
    private String updateTime;
}
