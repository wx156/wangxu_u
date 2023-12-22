package com.kfm.shop.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kfm.shop.system.domain.Menu;

import java.util.List;

/**
* @author wangxu
* @description 针对表【sys_menu】的数据库操作Mapper
* @createDate 2023-12-19 22:21:16
* @Entity com.kfm.menu.domain.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectMenusWithRoleIds(List<Integer> ids);
}




