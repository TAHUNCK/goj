package org.goj.file.controller;

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
    public String upload(@RequestPart("file") MultipartFile file) throws Exception {
        return fastDFSClient.upload(file);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestParam("url") String url) throws Exception {
        return fastDFSClient.deleteFile(url);
    }

    @PostMapping("/download")
    public byte[] download(@RequestParam("url") String url) throws Exception {
        return fastDFSClient.downFile(url);
    }

}
