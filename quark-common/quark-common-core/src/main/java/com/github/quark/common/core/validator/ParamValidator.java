package com.github.quark.common.core.validator;

import com.github.quark.common.core.exception.BusinessException;
import com.github.quark.common.core.model.ICode;
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
        return validateInernal(t, constraintViolations);
    }

    /**
     * 校验对象
     *
     * @param t      待校验对象
     * @param groups 待校验的组
     */
    public static <T> R<T> validate(T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, groups);
        return validateInernal(t, constraintViolations);
    }

    private static <T> R<T> validateInernal(T t, Set<ConstraintViolation<T>> constraintViolations) {
        if (!constraintViolations.isEmpty()) {
            StringBuilder errors = new StringBuilder();
            int i = 0;
            int size = constraintViolations.size();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                errors.append(constraintViolation.getMessage()).append(++i == size ? "" : "&");
            }
            //throw new BusinessException(ICode.REQUEST_PARAM_ILLEGAL.getCode(), errors.toString());
            return R.fail(ICode.REQUEST_PARAM_ILLEGAL.getCode(), errors.toString());
        }
        return R.successWith(t);
    }
}
