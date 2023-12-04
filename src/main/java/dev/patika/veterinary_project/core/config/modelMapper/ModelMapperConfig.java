package dev.patika.veterinary_project.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
