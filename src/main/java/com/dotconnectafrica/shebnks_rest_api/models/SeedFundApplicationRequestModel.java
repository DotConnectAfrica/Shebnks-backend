package com.dotconnectafrica.shebnks_rest_api.models;

import com.dotconnectafrica.shebnks_rest_api.Utility.Utility;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;


@Getter
@Setter
public class SeedFundApplicationRequestModel {

    private String username;
    private String name;
    private String about;
    private String statements;
    private String problems;
    private String solution;
    private String email;
    private String[] founders;

    private String number;
    private boolean womanOwned;
    private String[] sectors;
    private String[] primaryTarget;
    private String incomeGeneration;

    private String income;
    private boolean fundraised;
    private String scalingGoals;
    private Attachments attachments;
    private String otherInfo;
    String applicationCode="SFA"+new Utility().generateCode(5);

    @Getter
    @Setter
    public static class Attachments {
        private String projectBudget;
        private String shareCapital;
        private String jointStatement;
        private String taxAdminCert;
        private String annualFinacialStatement;
        private String others;

    }

}
