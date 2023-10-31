package com.kfm.boot.dao;

import com.kfm.boot.entity.FileModel;
import com.kfm.boot.util.DBHelper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileDao 用于处理文件表(file)数据
 */
@Repository
public class FileDao {

    private DBHelper db = new DBHelper();


    public List<FileModel> selectAll(FileModel fileModel, int pageNum, int pageSize) throws SQLException {
        StringBuilder sql = new StringBuilder("select * from file");
        //fileModel.getName() != null && !"".equals(fileModel.getName().trim())
        StringBuilder where = new StringBuilder();
        List param = new ArrayList();
        if (StringUtils.hasText(fileModel.getName())){
            where.append(" where name = ?");
            param.add(fileModel.getName());
        }

        if (!ObjectUtils.isEmpty(fileModel.getSearchDate())){
            // 如果没有传 name
            if (where.length() == 0){
                where.append(" where DATE(create_time) = ?");
            } else {
                where.append(" and DATE(create_time) = ?");
            }
            param.add(fileModel.getSearchDate());
        }
        if (where.length() > 0){
            sql.append(where);
        }

        sql.append(" limit ?, ?");
        param.add((pageNum - 1) * pageSize);
        param.add(pageSize);



        return db.selectList(sql.toString(), FileModel.class, param.toArray());
    }


    public int insert(FileModel model) throws SQLException {
        String sql = "insert into file(name, path, size, type, create_user) values(?,?,?,?,?)";
        return db.update(sql, model.getName(), model.getPath(), model.getSize(), model.getType(), model.getCreateUser());
    }
    public int getTotal(FileModel fileModel) throws SQLException {
        StringBuilder sql = new StringBuilder("select count(*) from file");
        StringBuilder where = new StringBuilder();
        List param = new ArrayList();
        if (StringUtils.hasText(fileModel.getName())){
            where.append(" where name = ?");
            param.add(fileModel.getName());
        }

        if (!ObjectUtils.isEmpty(fileModel.getSearchDate())){
            // 如果没有传 name
            if (where.length() == 0){
                where.append(" where DATE(create_time) = ?");
            } else {
                where.append(" and DATE(create_time) = ?");
            }
            param.add(fileModel.getSearchDate());
        }
        if (where.length() > 0){
            sql.append(where);
        }
        return db.selectCount(sql.toString(), param.toArray());
    }
}
