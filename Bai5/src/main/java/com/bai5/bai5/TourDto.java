package com.bai5.bai5;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@ValidTour
public class TourDto {
    @Pattern(regexp = "^(VN_|INT_)\\d{5}$", message = "Mã tour phải bắt đầu bằng VN_ hoặc INT_ theo sau là 5 chữ số")
    private String tourCode;

    @NotNull(message = "Vui lòng nhập giá người lớn")
    @Positive(message = "Giá phải lớn hơn 0")
    private Double adultPrice;

    @NotNull(message = "Vui lòng nhập giá trẻ em")
    @Positive(message = "Giá phải lớn hơn 0")
    private Double childPrice;

    @NotNull(message = "Vui lòng chọn ngày khởi hành")
    @FutureOrPresent(message = "Ngày khởi hành không được ở quá khứ")
    private LocalDate startDate;

    @NotNull(message = "Vui lòng chọn ngày kết thúc")
    private LocalDate endDate;

    public TourDto() {
    }

    public TourDto(String tourCode, Double adultPrice, Double childPrice, LocalDate startDate, LocalDate endDate) {
        this.tourCode = tourCode;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTourCode() {
        return tourCode;
    }

    public void setTourCode(String tourCode) {
        this.tourCode = tourCode;
    }

    public Double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(Double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(Double childPrice) {
        this.childPrice = childPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}