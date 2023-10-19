package com.kfm.clinetcloud;

import com.kfm.statics.StaticResources;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileMointer {
    public void start() throws Exception {
        // 通过指定目录创建一个观察对象
        FileAlterationObserver obServer = new FileAlterationObserver(StaticResources.FOLDERPATH);
        //向观察者对象注册一个文件监听器
        obServer.addListener(new FileListener());
        FileAlterationMonitor monitor = new FileAlterationMonitor(1000,obServer);
        monitor.start();
    }
}
