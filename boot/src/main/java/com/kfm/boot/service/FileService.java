package com.kfm.boot.service;

import com.kfm.boot.dao.FileDao;
import com.kfm.boot.entity.FileModel;
import com.kfm.boot.ex.ServiceException;
import com.kfm.boot.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private FileDao fileDao;

    public List<FileModel> list(FileModel fileModel,int pageNum,int pageSize) throws ServiceException {
        if (ObjectUtils.isEmpty(fileModel)){
            throw  new ServiceException("参数不能为空");
        }
        try {
            return fileDao.selectAll(fileModel,pageNum,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int getTotal(FileModel fileModel) throws ServiceException {
        if (ObjectUtils.isEmpty(fileModel)){
            throw new ServiceException("fileModel 参数不能为空");
        }
        try {
            return fileDao.getTotal(fileModel);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String save(MultipartFile file, Integer id) throws ServiceException {

        try {
            // 保存文件
            String path = saveFile(file, file.getOriginalFilename());

            // 存数据库
            FileModel model = new FileModel();
            model.setName(file.getOriginalFilename());
            model.setSize(file.getSize());
            model.setType(file.getContentType());
            model.setPath("/upload/" + path);
            model.setCreateUser(id);
            fileDao.insert(model);
            return model.getPath();
        } catch (IOException e) {
            throw new ServiceException("文件保存失败", e);
        } catch (SQLException e) {
            throw new ServiceException("文件信息存数据库失败", e);
        }


    }

    private String saveFile(MultipartFile multipartFile, String submittedFileName) throws IOException {
        // 按照日期存储. 获取日期的字符串 替换 - // 20231017
        String date = LocalDate.now().toString().replace("-", "");

        // 保存文件的路径   d:/temp/upload/20231017
        File file = new File(Constant.UPLOAD_PATH, date);

        // 判断文件夹是否存在
        if (!file.exists()){
            // 不存在创建
            file.mkdirs();
        }

            /*
             重命名文件，防止文件冲突
                时间戳
                UUID
             */

        // .jpg
        String substring = submittedFileName.substring(submittedFileName.lastIndexOf("."));


        String fileName = UUID.randomUUID().toString().replace("-", "");
        // 存文件  d:/temp/upload/20231017/fileName + substring
        multipartFile.transferTo(new File(file.getAbsolutePath(),fileName + substring));

        return date + "/" + fileName + substring;
    }
}
