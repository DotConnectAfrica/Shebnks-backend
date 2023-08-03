package com.dotconnectafrica.shebnks_rest_api.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@JsonPropertyOrder({
        "error",
        "message"
})
public class LoansCategoryResponse implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 7702134516418120340L;

    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("message")
    private String message;

    @JsonProperty("body")
    private List<ResponseDetails> responseDetails;

    @JsonIgnore
    private HttpStatus status;

    public LoansCategoryResponse() {

    }

    public LoansCategoryResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }


    public LoansCategoryResponse(Boolean error, String message, List<ResponseDetails> responseDetails) {
        this.error = error;
        this.message = message;
        this.responseDetails = responseDetails;
    }

    @Getter
    @Setter
    public static class ResponseDetails {
        private BigInteger id;
        private String loanCategoryName;
        private Integer loanMaximumAmount;
        private String loanRepaymentPeriod;
        private Integer loanInterest;
        private Integer loanMinimumAmount;

    }

}
