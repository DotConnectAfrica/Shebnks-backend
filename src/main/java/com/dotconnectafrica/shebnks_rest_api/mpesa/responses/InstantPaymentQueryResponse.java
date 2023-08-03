/*
 * Copyright 2019-2021 Daniel Ochieng' Olanga.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dotconnectafrica.shebnks_rest_api.mpesa.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A data interface representing Lipa Na Mpesa Payment query API response
 */
@SuppressWarnings("SameNameButDifferent")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class InstantPaymentQueryResponse {

    @Expose
    @SerializedName("MerchantRequestID")
    private String merchantRequestId;

    @Expose
    @SerializedName("CheckoutRequestID")
    private String checkoutRequestId;

    @Expose
    @SerializedName("ResponseCode")
    private String responseCode;

    @Expose
    @SerializedName("ResponseDescription")
    private String responseDescription;

    @Expose
    @SerializedName("ResultCode")
    private String resultCode;

    @Expose
    @SerializedName("ResultDesc")
    private String resultDesc;
}
