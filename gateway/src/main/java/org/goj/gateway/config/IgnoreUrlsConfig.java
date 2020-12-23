package org.goj.gateway.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网关白名单
 *
 * @author CK
 * @date 2020/11/23 11:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Component
@ConfigurationProperties(prefix="goj.security.ignore")
public class IgnoreUrlsConfig {
    private List<String> urls;
}
