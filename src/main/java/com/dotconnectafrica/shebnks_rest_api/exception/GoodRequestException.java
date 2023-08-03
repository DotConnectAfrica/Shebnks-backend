package com.dotconnectafrica.shebnks_rest_api.exception;

import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class GoodRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ApiResponse apiResponse;

    public GoodRequestException(ApiResponse apiResponse) {
        super();
        this.apiResponse = apiResponse;
    }

    public GoodRequestException(String message) {
        super(message);
    }

    public GoodRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
