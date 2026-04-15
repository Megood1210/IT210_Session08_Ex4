package com.bai4.bai4.validation;

import com.bai4.bai4.dto.RegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterDTO> {
    @Override
    public boolean isValid(RegisterDTO dto, ConstraintValidatorContext context) {
        if (dto == null) return true;

        String p = dto.getPassword();
        String c = dto.getConfirmPassword();

        if (p == null || c == null) return true;

        boolean match = p.equals(c);

        if (!match) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Mật khẩu không khớp")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return match;
    }
}
