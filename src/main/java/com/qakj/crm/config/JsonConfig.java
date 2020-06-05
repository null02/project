package com.qakj.crm.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
@Configuration
public class JsonConfig {
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 创建FastJson信息转换对象
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		// 创建Fastjosn对象并设定序列化规则
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 中文乱码解决方案
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);// 设定json格式且编码为 UTF-8
		fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
		// 规则赋予转换对象
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		return new HttpMessageConverters(fastJsonHttpMessageConverter);
	}
	
	// 配置跨域
		@Bean
		public CorsFilter corsFilter() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration corsConfiguration = new CorsConfiguration();
			corsConfiguration.addAllowedOrigin("*"); // 允许任何域名使用
			corsConfiguration.addAllowedHeader("*"); // 允许任何头
			corsConfiguration.addAllowedMethod("*"); // 允许任何方法（post、get等）
			corsConfiguration.setAllowCredentials(true);
			source.registerCorsConfiguration("/**", corsConfiguration); // 对接口配置跨域设置
			return new CorsFilter(source);
		}
}
