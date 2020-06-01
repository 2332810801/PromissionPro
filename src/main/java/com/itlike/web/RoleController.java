package com.itlike.web;

import com.itlike.domain.AjaxRes;
import com.itlike.domain.PageListRes;
import com.itlike.domain.QueryVo;
import com.itlike.domain.Role;
import com.itlike.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    /*注入业务层*/
    @Autowired
    private RoleService roleService;

    @RequestMapping("/role")
    public String employee(){
        return "role";
    }

    /*接收 请求角色列表 请求*/
    @RequestMapping("/getRoles")
    @ResponseBody
    public PageListRes getRoles(QueryVo vo){
        /*调用业务层, 查询角色列表*/
        PageListRes roles = roleService.getRoles(vo);
        return roles;
    }

    /*接收  保存角色请求地址*/
    @RequestMapping("/saveRole")
    @ResponseBody
    public AjaxRes saveRole(Role role){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层, 保存角色和权限*/
            roleService.saveRole(role);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
        }
        return ajaxRes;

    }

    /*更新角色请求*/
    @RequestMapping("/updateRole")
    @ResponseBody
    public AjaxRes updateRole(Role role){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用更新角色的业务*/
            roleService.updateRole(role);
            ajaxRes.setMsg("更新角色成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("更新角色失败");
        }
        return ajaxRes;

    }

    /*接收删除的请求*/
    @RequestMapping("/deleteRole")
    @ResponseBody
    public AjaxRes deleteRole(Long rid){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用删除角色的业务*/
            roleService.deleteRole(rid);
            ajaxRes.setMsg("删除角色成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("删除角色失败");
        }
        return ajaxRes;
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> roleList(){
       return  roleService.roleList();
    }

    /*根据用户id查询对应的角色*/
    @RequestMapping("/getRoleByEid")
    @ResponseBody
    public List<Long>getRoleByEid(Long id){
        /*查询对应的角色*/
        return roleService.getRoleByEid(id);
    }



}
