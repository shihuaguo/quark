package com.github.quark.common.core.validator;

import com.github.quark.common.core.enums.BizCode;
import com.github.quark.common.core.exception.BusinessException;
import com.github.quark.common.core.model.R;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Slf4j
public class ParamValidator {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> R<T> validate(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        if (!constraintViolations.isEmpty()) {
            StringBuilder errors = new StringBuilder();
            int i = 0;
            int size = constraintViolations.size();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                errors.append(constraintViolation.getMessage()).append(++i == size ? "" : "&");
            }
            throw new BusinessException(BizCode.REQUEST_PARAM_ILLEGAL.getCode(), errors.toString());
        }
        return R.success(t);
    }
}
