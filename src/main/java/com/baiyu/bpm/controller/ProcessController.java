package com.baiyu.bpm.controller;

import com.baiyu.bpm.bean.process.Process;
import com.baiyu.bpm.common.tools.JsonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 流程
 * @author lsx
 * @version 1.0
 * @createDate 2023/7/23 22:06
 */

@RestController
@RequestMapping("/process")
public class ProcessController {

    @PostMapping("/add")
    public JsonResult add(@RequestBody Process process){
        return JsonResult.success();
    }

    @PutMapping("/update")
    public JsonResult update(@RequestBody Process process){
        return JsonResult.success();
    }

    @DeleteMapping("/delete")
    public JsonResult delete(@RequestBody Process process){
        return JsonResult.success();
    }

    @PostMapping("/set")
    public JsonResult set(@RequestBody Process process){
        return JsonResult.success();
    }

    @PostMapping("/list")
    public JsonResult list(@RequestBody Process process){
        return JsonResult.success();
    }

}
