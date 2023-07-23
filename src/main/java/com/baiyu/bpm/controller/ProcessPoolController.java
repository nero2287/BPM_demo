package com.baiyu.bpm.controller;

import com.baiyu.bpm.bean.process.ProcessDiscarded;
import com.baiyu.bpm.bean.process.ProcessHistorical;
import com.baiyu.bpm.bean.process.ProcessOngoing;
import com.baiyu.bpm.common.tools.JsonResult;
import org.springframework.web.bind.annotation.*;

/**
 * 流程池
 * @author lsx
 * @version 1.0
 * @createDate 2023/7/23 22:53
 */
@RestController
@RequestMapping("/process-pool")
public class ProcessPoolController {

    @PutMapping("/discard")
    public JsonResult discard(String form_code){
        return JsonResult.success();
    }

    @GetMapping("/ongoing/list")
    public JsonResult ongoing(@RequestBody ProcessOngoing processOngoing){
        return JsonResult.success();
    }

    @Deprecated
    @GetMapping("/history/list")
    public JsonResult history(@RequestBody ProcessHistorical processHistorical){
        return JsonResult.success();
    }

    @Deprecated
    @GetMapping("/discarded/list")
    public JsonResult discarded(@RequestBody ProcessDiscarded processDiscarded){
        return JsonResult.success();
    }
}
