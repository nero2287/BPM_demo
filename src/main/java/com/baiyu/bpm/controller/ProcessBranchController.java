package com.baiyu.bpm.controller;

import com.baiyu.bpm.bean.process.ProcessBranch;
import com.baiyu.bpm.bean.process.ProcessBranchConditions;
import com.baiyu.bpm.bean.process.ProcessBranchNode;
import com.baiyu.bpm.common.tools.JsonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 流程分支
 * @author lsx
 * @version 1.0
 * @createDate 2023/7/23 22:12
 */
@RestController
@RequestMapping("/process/branch")
public class ProcessBranchController {

    /**
     * 新增一个分支
     * @param processBranchConditions
     * @return
     */
    @PostMapping("/add")
    public JsonResult add(@RequestBody ProcessBranchConditions processBranchConditions){
        return JsonResult.success();
    }

    /**
     * 设置分支执行的顺序
     * @param processBranchNodeList
     * @return
     */
    @PostMapping("/set")
    public JsonResult set(@RequestBody List<ProcessBranchNode> processBranchNodeList){
        return JsonResult.success();
    }

    /**
     * 修改分支条件
     * @param processBranchConditions
     * @return
     */
    @PutMapping("/update")
    public JsonResult put(@RequestBody ProcessBranchConditions processBranchConditions){
        return JsonResult.success();
    }

    /**
     * 删除流程的分支
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public JsonResult delete(@PathVariable String id){
        return JsonResult.success();
    }
}
