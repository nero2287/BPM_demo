package com.baiyu.bpm.bean.process;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 分支-节点关联顺序
 * @author lsx
 * @createDate 2023-07-23 21:26:25
 * @version 1.0
 */
@Data
public class ProcessBranchNode {
    /**
     * 主键
     */
    private int id;
    /**
     * 流程编码
     */
    private String process_code;
    /**
     * 节点编码
     */
    private String node_code;
    /**
     * 节点名称
     */
    private String node_name;
    /**
     * 分支中流程节点的顺序
     */
    private int node_step;
}
