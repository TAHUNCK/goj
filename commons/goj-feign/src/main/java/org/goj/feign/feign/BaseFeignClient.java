package org.goj.feign.feign;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.goj.common.entity.base.Email;
import org.goj.common.model.Result;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CK
 * @date 2020/12/15 17:08
 */
@FeignClient(name = "base", configuration = BaseFeignClient.MyConfig.class)
public interface BaseFeignClient {

    /**
     * 发送简单邮件
     *
     * @param email 邮件对象
     * @return Result<String>
     * @author CK
     * @date 2020/12/15 19:29
     */
    @PostMapping(value = "/email/simpleEmail",consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<String> sendSimpleEmail(@RequestBody Email email);

    /**
     * 文件上传接口
     *
     * @param file Spring的文件格式
     * @return String
     * @author CK
     * @date 2020/10/18 13:15
     */
    @PostMapping(value = "/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile file);

    /**
     * 删除文件
     *
     * @param url 文件路径
     * @return Boolean
     * @author CK
     * @date 2020/10/18 13:20
     */
    @PostMapping(value = "/file/delete")
    Boolean delete(@RequestParam(value = "url") String url);

    /**
     * 下载文件
     *
     * @param url 文件路径
     * @return byte[]
     * @author CK
     * @date 2020/10/18 13:20
     */
    @PostMapping(value = "/file/download")
    byte[] download(@RequestParam(value = "url") String url);

    @Configuration
    class MyConfig {
        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }
    }

}
