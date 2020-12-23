package org.goj.gateway.filter;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.nimbusds.jose.JWSObject;
import org.goj.common.constant.AuthConstant;
import org.goj.common.constant.ResultCode;
import org.goj.common.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;

/**
 * @author CK
 * @date 2020/12/16 10:21
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders header = exchange.getRequest().getHeaders();
        String token = header.getFirst(AuthConstant.AUTHORIZATION);
        String userId = header.getFirst(AuthConstant.USER_ID);
        //application.yml已允许放行且无token
        if (StrUtil.isEmpty(token)) {
            return chain.filter(exchange);
        }
        try {
            //从token中解析用户信息并设置到Header中去
            JWSObject jwsObject = JWSObject.parse(token);
            String userStr = jwsObject.getPayload().toString();
            Assert.notBlank(userId, "UserId不存在！");
            if (!userId.equals(JSONUtil.parseObj(userStr).getStr(AuthConstant.USER_ID))) {
                //不允许访问，禁止访问
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
                String body= JSONUtil.toJsonStr(Result.failed(ResultCode.USER_ERROR_A0300.getCode(),ResultCode.USER_ERROR_A0300.getMessage(),"请注意你的行为！"));
                DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
                return response.writeWith(Mono.just(buffer));
            }
            LOGGER.info("AuthGlobalFilter.filter() user:{}", userStr);
            ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().header("user", userStr).build();
            exchange = exchange.mutate().request(serverHttpRequest).build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
