package com.library.project.dto;

import com.library.project.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    @NotBlank
    private int tokenId;

    @NotBlank
    private String value;

    @NotBlank
    public boolean revoked;

    @NotBlank
    public boolean expired;

    @NotBlank
    private User user;
}
