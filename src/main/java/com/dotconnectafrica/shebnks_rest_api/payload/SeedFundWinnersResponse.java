package com.dotconnectafrica.shebnks_rest_api.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@JsonPropertyOrder({
        "error",
        "message"
})
public class SeedFundWinnersResponse implements Serializable {

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

    public SeedFundWinnersResponse() {

    }

    public SeedFundWinnersResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }


    public SeedFundWinnersResponse(Boolean error, String message, List<ResponseDetails> responseDetails) {
        this.error = error;
        this.message = message;
        this.responseDetails = responseDetails;
    }

    @Getter
    @Setter
    public static class ResponseDetails {

        @JsonIgnore
        private Long winner_id;
        private String winner_title;
        private String winner_image_link;
        private String winner_info;
        private String winner_article_link;
        private String winning_year;

    }

}
