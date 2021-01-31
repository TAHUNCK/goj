package org.goj.file.controller;

import org.goj.common.model.Result;
import org.goj.file.util.FastDFSClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author CK
 * @date 2020/10/11 17:12
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    FastDFSClient fastDFSClient;

    @PostMapping("/upload")
    public Result<String> upload(@RequestPart("file") MultipartFile file) {
        try{
            return Result.succeed("文件上传成功！",fastDFSClient.upload(file));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("文件上传失败！");
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam("url") String url) {
        try {
            return Result.succeed("文件删除成功！",fastDFSClient.deleteFile(url));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("文件删除失败！");
        }
    }

    @PostMapping("/download")
    public Result<byte[]> download(@RequestParam("url") String url) {
        try {
            return Result.succeed("文件下载成功！",fastDFSClient.downFile(url));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("文件下载失败！");
        }
    }

}
