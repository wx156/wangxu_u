package com.kfm.boot.dao;

import com.kfm.boot.entity.FileModel;
import com.kfm.boot.util.DBHelper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * FileDao 用于处理文件表(file)数据
 */
@Repository
public class FileDao {

    private DBHelper db = new DBHelper();


    public List<FileModel> selectAll() throws SQLException {
        String sql = "select * from file";
        return db.selectList(sql, FileModel.class);
    }


    public int insert(FileModel model) throws SQLException {
        String sql = "insert into file(name, path, size, type, create_user) values(?,?,?,?,?)";
        return db.update(sql, model.getName(), model.getPath(), model.getSize(), model.getType(), model.getCreateUser());
    }
}
