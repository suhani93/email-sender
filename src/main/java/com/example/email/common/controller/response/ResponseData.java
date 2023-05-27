package com.example.email.common.controller.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseData<T> {
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("item")
    private T item;


    public static <T> ResponseData<T> success(T item) {
        ResponseData<T> response = new ResponseData<>();
        response.code = "SUCCESS";
        response.message = "";
        response.item = item;
        return response;
    }
}
