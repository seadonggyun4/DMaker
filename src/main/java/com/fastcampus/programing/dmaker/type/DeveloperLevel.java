package com.fastcampus.programing.dmaker.type;


import com.fastcampus.programing.dmaker.exception.DMakerErrorCode;
import com.fastcampus.programing.dmaker.exception.DMakerException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

import static com.fastcampus.programing.dmaker.constant.DMakerConstant.MAX_JUNIOR_EXPERIENCE_YEARS;
import static com.fastcampus.programing.dmaker.constant.DMakerConstant.MIN_SENIOR_EXPERIENCE_YEARS;
import static com.fastcampus.programing.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@AllArgsConstructor // -> 생성자를 만들어준다.
@Getter
public enum DeveloperLevel {
//    New("신입 개발자", 0,0),
//    JUNIOR("주니어 개발자", 1, MAX_JUNIOR_EXPERIENCE_YEARS),
//    JUNGNIOR("중니어 개발자", MAX_JUNIOR_EXPERIENCE_YEARS+1, MIN_SENIOR_EXPERIENCE_YEARS-1),
//    SENIOR("시니어 개발자", MIN_SENIOR_EXPERIENCE_YEARS, 70);
//
//    private final String description;
//    private final Integer minExperienceYears;
//    private final Integer maxExperienceYears;

    New("신입 개발자", years -> years == 0),
    JUNIOR("주니어 개발자", years -> years <= MAX_JUNIOR_EXPERIENCE_YEARS),
    JUNGNIOR("중니어 개발자", years -> years > MAX_JUNIOR_EXPERIENCE_YEARS
            && years < MIN_SENIOR_EXPERIENCE_YEARS),
    SENIOR("시니어 개발자", years -> years >= MIN_SENIOR_EXPERIENCE_YEARS);

    private final String description;
    private final Function<Integer, Boolean> validateFunction;


    // validateFunction 동작 결과가 실패하면 연차가 맞지 않다는 exception발생시킨다.
    public void validateExperienceYears(Integer years) {
        if(!validateFunction.apply(years)){
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
    }
}
