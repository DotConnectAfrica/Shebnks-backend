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
public class UserProfileResponse implements Serializable {

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

    public UserProfileResponse() {

    }

    public UserProfileResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }


    public UserProfileResponse(Boolean error, String message, ResponseDetails responseDetails) {
        this.error = error;
        this.message = message;
        this.responseDetails = responseDetails;
    }

    @Getter
    @Setter
    public static class ResponseDetails {
        private BigInteger userId;
        private String firstName;
        private String middleName;
        private String lastName;
        private String emailAddress;
        private String password;
        private Integer balance;
        private String currency;
        private String cardExpiry;
        private String verifiedNumber;
        private String mobileuuid;
        private String firebaseId;
        private String mobileNumber;
        private String loanLimit;
        private Integer sheloans;
        private String shebnksCardNumber;
        private String uuid;
        private String profileImage;
        private String messagingToken;
        private Integer accountVerificationStatus;
        private String idNumber;

    }

}
