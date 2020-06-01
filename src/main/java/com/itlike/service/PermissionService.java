package com.itlike.service;

import com.itlike.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> getPermissions();
    /*根据角色查询对应的权限*/
    List<Permission> getPermissionByRid(Long rid);
}
