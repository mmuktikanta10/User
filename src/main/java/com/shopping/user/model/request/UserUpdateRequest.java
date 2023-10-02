package com.shopping.user.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shopping.user.annotations.IsValidFields;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateRequest {
    @IsValidFields
    private Map<String, String> updateFields;
}
