package com.digikalspring.digikalspring.dto;

import com.digikalspring.digikalspring.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class RegisterResponseDto {
   @JsonProperty("message")
   private String message;
}
