package com.baiyu.bpm.controller;

import com.baiyu.bpm.bean.process.ProcessNode;
import com.baiyu.bpm.common.tools.JsonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 流程节点
 * @author lsx
 * @version 1.0
 * @createDate 2023/7/23 22:06
 */
@RestController
@RequestMapping("/process/node")
public class ProcessNodeController {

    @PostMapping("/add")
    public JsonResult processNodeAdd(@RequestBody List<ProcessNode> processNodeList){
        return JsonResult.success();
    }

    @PutMapping("/update")
    public JsonResult processNodeUpdate(@RequestBody ProcessNode processNode){
        return JsonResult.success();
    }

    @DeleteMapping("/delete")
    public JsonResult processNodeDelete(@RequestBody ProcessNode processNode){
        return JsonResult.success();
    }

    @PostMapping("/set")
    public JsonResult processSet(@RequestBody ProcessNode processNode){
        return JsonResult.success();
    }
}
