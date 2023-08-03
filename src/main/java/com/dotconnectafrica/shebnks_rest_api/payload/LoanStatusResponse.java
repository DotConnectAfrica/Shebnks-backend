package com.dotconnectafrica.shebnks_rest_api.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@JsonPropertyOrder({
        "error",
        "message"
})
public class LoanStatusResponse implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 7702134516418120340L;

    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("message")
    private String message;

    @JsonProperty("loan_data")
    private List<ResponseDetails> responseDetails;

    @JsonProperty("request")
    private requestDetails requestDetails;


    public LoanStatusResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }


    public LoanStatusResponse(Boolean error, String message, List<ResponseDetails> responseDetails, requestDetails requestDetails) {
        this.error = error;
        this.message = message;
        this.responseDetails = responseDetails;
        this.requestDetails = requestDetails;
    }

    @Getter
    @Setter
    public static class ResponseDetails {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private BigInteger loanId;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String loanCode;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Integer loanAmount;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Integer loanInterestAccrued;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Integer loanBalance;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Integer amountPaid;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String lastPaidDate;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Integer loanStatus;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String loanCategory;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String loanApplicationDate;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean loanDisbursement;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String dateGiven;

        private String loanDueDate;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String loanMobile;


        private String loanLimit;


    }

    @Getter
    @Setter
    public static class requestDetails {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private BigInteger id;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String userName;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String email;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String phoneNumber;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String governmentId;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String date_applied;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean rejection_message_seen;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String date_approved;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean approved;


    }

}
