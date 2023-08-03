package com.dotconnectafrica.shebnks_rest_api.mpesa.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class StkCallBackResponse {

    @JsonProperty("Body")
    private Body body;

        @Getter
        public static class Body{

            @JsonProperty("stkCallback")
            private stkCallback stkCallback;

            @Getter
            public static class stkCallback {

                @JsonProperty("ResultCode")
                private Integer resultCode;

                @JsonProperty("MerchantRequestID")
                private String merchantRequestID;

                @JsonProperty("CheckoutRequestID")
                private String checkoutRequestID;

                @JsonProperty("ResultDesc")
                private String resultDesc;

                @JsonProperty("CallbackMetadata")
                private CallbackMetadata callbackMetadata;

                @Getter
                public static class CallbackMetadata {

                    @JsonProperty("Item")
                    List<Item> itemList;

                    @Getter
                    public static class Item {

                        @JsonProperty("Name")
                        private String name;

                        @JsonProperty("Value")
                        private String value;

                    }
                }
            }
    }
}
