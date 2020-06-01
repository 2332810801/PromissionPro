package com.itlike.web;

import com.itlike.domain.Department;
import com.itlike.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class departmentController {

    /*注入业务*/
    @Autowired
    private DepartmentService departmentService;

    /*查询部门*/
    @RequestMapping("/departList")
    @ResponseBody
    public List<Department> departList(){
        List<Department> departmentList = departmentService.getDepartmentList();
        return departmentList;
    }

}
