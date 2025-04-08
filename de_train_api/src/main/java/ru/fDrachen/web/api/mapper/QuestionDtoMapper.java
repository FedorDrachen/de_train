package ru.fDrachen.web.api.mapper;

import org.mapstruct.Mapper;
import ru.fDrachen.domain.model.OpenQuestionCard;
import ru.fDrachen.web.api.dto.OpenQuestionCardDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionDtoMapper {
    OpenQuestionCard mapToModel(OpenQuestionCardDto entity);
    OpenQuestionCardDto mapToDto(OpenQuestionCard question);
    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardDto> entities);
    List<OpenQuestionCardDto> mapToDto(List<OpenQuestionCard> questions);
}
