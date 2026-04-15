package com.bai5.bai5;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TourValidator implements ConstraintValidator<ValidTour, TourDto> {
    @Override
    public boolean isValid(TourDto dto, ConstraintValidatorContext context) {
        if (dto == null) return true;
        boolean valid = true;


        if (dto.getAdultPrice() != null && dto.getChildPrice() != null) {
            if (dto.getChildPrice() > dto.getAdultPrice()) {
                valid = false;

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Giá trẻ em không được lớn hơn giá người lớn")
                        .addPropertyNode("childPrice").addConstraintViolation();
            }
        }

        if (dto.getStartDate() != null && dto.getEndDate() != null) {
            if (!dto.getEndDate().isAfter(dto.getStartDate())) {
                valid = false;
                context.buildConstraintViolationWithTemplate("Ngày kết thúc phải sau ngày khởi hành")
                        .addPropertyNode("endDate").addConstraintViolation();
            }
        }
        return valid;
    }
}