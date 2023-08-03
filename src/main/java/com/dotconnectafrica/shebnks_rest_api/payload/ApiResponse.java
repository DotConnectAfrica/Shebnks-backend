package com.dotconnectafrica.shebnks_rest_api.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@JsonPropertyOrder({
        "error",
        "message"
})
public class ApiResponse implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 7702134516418120340L;

    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("message")
    private String message;

    @JsonIgnore
    private HttpStatus status;

    public ApiResponse() {

    }

    public ApiResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }


    public ApiResponse(Boolean error, String message, HttpStatus httpStatus) {
        this.error = error;
        this.message = message;
        this.status = httpStatus;

    }

}
