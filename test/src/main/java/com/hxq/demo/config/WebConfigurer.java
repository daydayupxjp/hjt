package com.hxq.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonpHttpMessageConverter4;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebConfigurer
 * @Description 消息转换器
 * @Author hongxq
 * @Date 2019/11/1 15:45
 * @Version 1.0
 **/
@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonpHttpMessageConverter4 converter = new FastJsonpHttpMessageConverter4();
        converter.setSupportedMediaTypes(getSupportedMediaTypes());
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures( // String null -> ""
            SerializerFeature.WriteNullStringAsEmpty,
            // Number null -> 0
            SerializerFeature.WriteNullNumberAsZero,
            //禁止循环引用
            SerializerFeature.DisableCircularReferenceDetect,
            //List字段如果为null,输出为[],而非null
            SerializerFeature.WriteNullListAsEmpty,
            //字符类型字段如果为null,输出为"",而非null
            SerializerFeature.WriteNullStringAsEmpty ,
            //Boolean字段如果为null,输出为false,而非null
            SerializerFeature.WriteNullBooleanAsFalse,
            //是否输出值为null的字段,默认为false
            SerializerFeature.WriteMapNullValue
        );
        converter.setFastJsonConfig(fastJsonConfig);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        return supportedMediaTypes;
    }


}
