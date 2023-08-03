package com.dotconnectafrica.shebnks_rest_api.mpesa.rest.params;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessToken {

    @Expose
    @SerializedName("access_token")
    private String accessToken;

    @Expose
    @SerializedName("expires_in")
    private String expiresIn;
}
