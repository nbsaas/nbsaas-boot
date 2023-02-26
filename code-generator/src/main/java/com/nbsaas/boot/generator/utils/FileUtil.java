package com.nbsaas.boot.generator.utils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author:Rhythm-2019
 * date: 2020/3/9
 * description: 文件操作工具类
 */
public class FileUtil {

    /**
     * 创建文件
     *
     * @param basePath 基础文件夹
     * @param fileName 文件名
     * @return 被创建的文件
     * @throws IOException IO异常
     */
    public static File createDirAndFile(String basePath, String fileName) throws IOException {
        File file = new File(basePath, fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        return file;
    }

    public static void createDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static File createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            // throw new RuntimeException("folder no found, please create the parent folder first");
        }
        file.createNewFile();
        return file;
    }

    /**
     * 查询文件夹中的所有文件列表
     *
     * @param folderFile 文件见/文件
     * @return 文件列表
     */
    public static List<File> getFileList(File folderFile) {
        List<File> allFileList = new ArrayList<>();
        if (!folderFile.isDirectory()) {
            // 入参是一个文件，直接返回
            allFileList.add(folderFile);
            return allFileList;
        }
        // 入参是一个文件夹，需要递归遍历
        _getAllFile(folderFile, allFileList);
        return allFileList;

    }

    private static void _getAllFile(File file, List<File> allFileList) {

        // Terminator
        File[] innerFiles = file.listFiles();
        if (innerFiles == null || innerFiles.length == 0) {
            return;
        }
        // Process
        for (File innerFile : innerFiles) {
            // Process
            if (innerFile.isDirectory()) {
                // 文件夹
                _getAllFile(innerFile, allFileList);
            } else {
                // 文件
                allFileList.add(innerFile);
            }
        }
    }

    /**
     * 删除文件夹所有文件
     *
     * @param path 路径
     */
    public static void delDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        _delDir(file);
    }

    private static void _delDir(File folder) {
        // Terminator

        // Process
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                // Drull dwon
                _delDir(file);
            } else {
                file.delete();
            }
        }

        folder.delete();
    }
}
