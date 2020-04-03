package com.yanzhenyidai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author frank
 * @version 1.0
 * @date 2019-09-01 13:19
 */
@EnableResourceServer
@Configuration
public class AuthResourceConfig extends ResourceServerConfigurerAdapter {

        @Autowired
        RedisConnectionFactory redisConnectionFactory;

    //    @Autowired
    //    DataSource dataSource;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            super.configure(resources);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.
                    csrf().disable()
                    .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .httpBasic();
        }

    //    @Bean
    //    ResourceServerTokenServices resourceServerTokenServices() {
    //        RemoteTokenServices tokenServices = new RemoteTokenServices();
    //        tokenServices.setCheckTokenEndpointUrl("http://localhost:8081/oauth/check_token");
    //        tokenServices.setAccessTokenConverter(accessTokenConverter());
    //        return tokenServices;
    //    }

        @Bean
        public AccessTokenConverter accessTokenConverter() {
            return new DefaultAccessTokenConverter();
        }

        @Bean
        RedisTokenStore redisTokenStore() {
            return new RedisTokenStore(redisConnectionFactory);
        }

    //    @Bean
    //    ClientDetailsService clientDetailsService() {
    //        return new JdbcClientDetailsService(dataSource);
    //    }

        @Bean
        @Primary
        DefaultTokenServices defaultTokenServices() {
            DefaultTokenServices tokenServices = new DefaultTokenServices();
            tokenServices.setTokenStore(redisTokenStore());
    //        tokenServices.setSupportRefreshToken(true);
    //        tokenServices.setClientDetailsService(clientDetailsService());
    //        tokenServices.setAccessTokenValiditySeconds(60 * 60 * 12); // token有效期自定义设置，默认12小时
    //        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);//默认30天，这里修改
            return tokenServices;
        }
}
