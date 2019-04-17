package com.yzpjy.controller;

import com.github.pagehelper.PageInfo;
import com.yzpjy.domain.Syslog;
import com.yzpjy.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SyslogController {

    @Autowired
    private SyslogService syslogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "8") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Syslog> all = syslogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("sysLogs",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }


}
