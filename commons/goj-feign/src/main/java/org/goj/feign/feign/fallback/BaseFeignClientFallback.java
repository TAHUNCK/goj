package org.goj.feign.feign.fallback;

import org.goj.common.entity.base.Email;
import org.goj.common.model.Result;
import org.goj.feign.feign.BaseFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CK
 * @date 2021/1/31 13:21
 */
@Component
public class BaseFeignClientFallback implements BaseFeignClient {
    @Override
    public Result<String> sendSimpleEmail(Email email) {
        return Result.failed("发送邮件失败！");
    }

    @Override
    public Result<String> upload(MultipartFile file) {
        return Result.failed("文件上传失败！");
    }

    @Override
    public Result<Boolean> delete(String url) {
        return Result.failed("文件删除失败！");
    }

    @Override
    public Result<byte[]> download(String url) {
        return Result.failed("文件下载失败！");
    }
}
