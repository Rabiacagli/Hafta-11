package dev.patika.library.core.config.modelMapper;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}

