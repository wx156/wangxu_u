package com.kfm.clinetcloud;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

public class FileListener extends FileAlterationListenerAdaptor {
    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
    }

    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
    }

    @Override
    public void onDirectoryDelete(File directory) {
        super.onDirectoryDelete(directory);
    }

    @Override
    public void onFileChange(File file) {
        super.onFileChange(file);
    }

    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
    }

    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);
    }
}
