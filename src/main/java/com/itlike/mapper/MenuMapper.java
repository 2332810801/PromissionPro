package com.itlike.mapper;

import com.itlike.domain.Menu;
import java.util.List;

public interface MenuMapper {
    /*根据id删除菜单*/
    int deleteByPrimaryKey(Long id);
    /*根据id查询菜单*/
    Menu selectByPrimaryKey(Long id);
    /*查询所有菜单*/
    List<Menu> selectAll();
    /*更新菜单*/
    int updateByPrimaryKey(Menu record);
    /*保存菜单*/
    void saveMenu(Menu menu);
    /*根据id查询父菜单id*/
    Long selectParentId(Long id);
    /*更新菜单关系*/
    void updateMenuRel(Long id);

    /*获取树形菜单数据*/
    List<Menu> getTreeData();

}