package com.example.springApi.testApiJava.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UpdateUserStatusResponseDTO {
    private Long id;
    private boolean previousStatus;
    private boolean currentStatus;

    public UpdateUserStatusResponseDTO(Long id, boolean previousStatus, boolean currentStatus) {
        this.id = id;
        this.previousStatus = previousStatus;
        this.currentStatus = currentStatus;
    }
}
