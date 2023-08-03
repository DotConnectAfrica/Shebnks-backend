package com.dotconnectafrica.shebnks_rest_api.mpesa.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class MpesaResponse {

    @JsonProperty("Result")
    private Result result;

    @Getter
    public static class Result{

        @JsonProperty("ResultType")
        private Integer resultType;

        @JsonProperty("ResultCode")
        private Integer resultCode;

        @JsonProperty("ResultDesc")
        private String resultDesc;

        @JsonProperty("OriginatorConversationID")
        private String originatorConversationID;

        @JsonProperty("ConversationID")
        private String conversationID;

        @JsonProperty("TransactionID")
        private String transactionID;

        @JsonProperty("ResultParameters")
        private ResultParameters resultParameters;

        @Getter
        public static class ResultParameters{

            @JsonProperty("ResultParameter")
            List<ResultParameter> resultParameterList;

            @Getter
            public static class ResultParameter {

                @JsonProperty("Key")
                private String key;

                @JsonProperty("Value")
                private String value;

            }
            }

        @JsonProperty("ReferenceData")
        private ReferenceData referenceData;

        @Getter
        public static class ReferenceData{

            @JsonProperty("ReferenceItem")
            ReferenceItem referenceItem;

            @Getter
            public static class ReferenceItem {

                @JsonProperty("Key")
                private String key;

                @JsonProperty("Value")
                private String value;

            }
        }



    }
}
