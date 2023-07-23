package com.baiyu.bpm.bean.process;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 流程分支
 * @author lsx
 * @version 1.0
 * @createDate 2023/7/23 22:25
 */
@Data
public class ProcessBranch {
    /**
     * 主键
     */
    @TableId
    private int id;
    /**
     * 流程编码
     */
    private String processCode;
    /**
     * 分支编码
     */
    private String condition_code;
    /**
     * 执行步骤
     */
    private String branch_step;
}
