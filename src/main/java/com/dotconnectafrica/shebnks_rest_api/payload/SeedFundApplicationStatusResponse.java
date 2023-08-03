package com.dotconnectafrica.shebnks_rest_api.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Data
@JsonPropertyOrder({
        "error",
        "message"
})
public class SeedFundApplicationStatusResponse implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 7702134516418120340L;

    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("message")
    private String message;

    @JsonProperty("body")
    private ResponseDetails responseDetails;

    @JsonIgnore
    private HttpStatus status;

    public SeedFundApplicationStatusResponse() {

    }

    public SeedFundApplicationStatusResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }


    public SeedFundApplicationStatusResponse(Boolean error, String message, ResponseDetails responseDetails) {
        this.error = error;
        this.message = message;
        this.responseDetails = responseDetails;
    }

    @Getter
    @Setter
    public static class ResponseDetails {

        private Integer receivedStatus;
        private Integer conditionStatus;
        private Integer adminCheckStatus;
        private Integer evaluationStatus;
        private Integer applicationStatus;

    }

}
