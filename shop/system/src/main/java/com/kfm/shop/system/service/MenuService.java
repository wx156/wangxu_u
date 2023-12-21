package com.kfm.shop.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kfm.shop.system.domain.Menu;

import java.util.List;

/**
* @author wangxu
* @description 针对表【sys_menu】的数据库操作Service
* @createDate 2023-12-19 22:21:16
*/
public interface MenuService extends IService<Menu> {

    List<Tree<Integer>> treeList(Menu menu);
}
