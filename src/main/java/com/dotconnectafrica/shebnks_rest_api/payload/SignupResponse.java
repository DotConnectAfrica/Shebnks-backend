package com.dotconnectafrica.shebnks_rest_api.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@JsonPropertyOrder({
        "error",
        "message"
})
public class SignupResponse implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 770213451641812034L;

    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("message")
    private String message;

    @JsonIgnore
    private HttpStatus status;

    @JsonProperty("body")
    private ResponseDetails responseDetails;

    public SignupResponse() {

    }

    public SignupResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public SignupResponse(Boolean error, String message, ResponseDetails responseDetails) {
        this.error = error;
        this.message = message;
        this.responseDetails = responseDetails;

    }

    public SignupResponse(Boolean error, String message, HttpStatus httpStatus) {
        this.error = error;
        this.message = message;
        this.status = httpStatus;

    }

    @Getter
    @Setter
    public static class ResponseDetails {
        private BigInteger id;
        private String phone;
        private String first_name;
        private String last_name;
        private String email;
        private String token;
        @JsonIgnore
        private String refreshToken;
        private String type = "Bearer";
    }
}