package com.kfm.boot.controller;

import com.kfm.boot.entity.FileModel;
import com.kfm.boot.entity.Page;
import com.kfm.boot.entity.User;
import com.kfm.boot.ex.ServiceException;
import com.kfm.boot.service.FileService;
import com.kfm.boot.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/file") // 通过这里配置使下面的映射都在 /file 下
@Controller
@ResponseBody // 该注解表示该类的所有方法返回的数据直接写给浏览器，如果是对象转为 json 数据
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView mv,
                             @RequestParam(value = "p",defaultValue = "1") int pageNum,
                             @RequestParam(value = "s", defaultValue = "5") int pageSize,
                             FileModel fileModel) throws ServiceException {

        List<FileModel> list = fileService.list(fileModel,pageNum,pageSize);
        int total = fileService.getTotal(fileModel);
        // 构建一个分页对象
        Page page = new Page(pageNum,pageSize,total,list);
        mv.addObject("page",page);
        mv.addObject("search",fileModel);
        mv.setViewName("file/list");
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("file/add");
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("img") MultipartFile file, @SessionAttribute(Constant.LOGIN_USER) User user) {
        ModelAndView mv = new ModelAndView("redirect:/file/list");
        if (!file.isEmpty()){
            try {
                fileService.save(file, user.getId());
            } catch (ServiceException e) {
                e.printStackTrace();
                mv.setViewName("file/add");
            }
        }
        return mv;
    }
}
