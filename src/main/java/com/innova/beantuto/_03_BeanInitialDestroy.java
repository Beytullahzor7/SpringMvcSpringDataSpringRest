package com.innova.beantuto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class _03_BeanInitialDestroy {

    @Bean(initMethod = "initialBEanMethod", destroyMethod = "destroyBEanMethod")
    @Scope("session")
    public BeanDto beanInitialDestroy(){
        return BeanDto.builder().id(0L).beanName("Data BeanInitialDestroy").beanData("Adi BeanInitialDestroy").build();
    }
}
