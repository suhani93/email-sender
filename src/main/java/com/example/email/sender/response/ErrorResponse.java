package com.example.email.sender.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponse{
    private List<String> errors;
}