package com.dotconnectafrica.shebnks_rest_api.models;

public class updateDataToSpreadSheetModel {
    String date;
    String phone;
    String code;
    String amount;
    String interest;
    String totalAmount;
    String loanBalance;
    String amountPaid;
    String interestPaid;
    String principlePaid;
    String lastPaidDate;
    String loanTerm;
    String loanDisbursement;
    String loanStatus;
    String dateGiven;
    String dueDate;
    String channel;
    String bankName;
    String bankBranch;

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }


    String nameCategory;
    String disburseLoanLink;
    String denyLoanLink;

    public updateDataToSpreadSheetModel(String date, String phone, String code, String amount, String interest, String loanBalance, String lastPaidDate, String loanDisbursement, String loanStatus, String dateGiven, String dueDate, String nameCategory, String disburseLoanLink, String denyLoanLink) {



        this.date = date;
        this.phone = phone;
        this.code = code;
        this.amount = amount;
        this.interest = interest;

        this.loanBalance = loanBalance;

        this.lastPaidDate = lastPaidDate;

        this.loanDisbursement = loanDisbursement;
        this.loanStatus = loanStatus;
        this.dateGiven = dateGiven;
        this.dueDate = dueDate;


        this.nameCategory = nameCategory;
        this.disburseLoanLink = disburseLoanLink;
        this.denyLoanLink = denyLoanLink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }



    public String getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(String loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(String interestPaid) {
        this.interestPaid = interestPaid;
    }

    public String getPrinciplePaid() {
        return principlePaid;
    }

    public void setPrinciplePaid(String principlePaid) {
        this.principlePaid = principlePaid;
    }

    public String getLastPaidDate() {
        return lastPaidDate;
    }

    public void setLastPaidDate(String lastPaidDate) {
        this.lastPaidDate = lastPaidDate;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanDisbursement() {
        return loanDisbursement;
    }

    public void setLoanDisbursement(String loanDisbursement) {
        this.loanDisbursement = loanDisbursement;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getDateGiven() {
        return dateGiven;
    }

    public void setDateGiven(String dateGiven) {
        this.dateGiven = dateGiven;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }





    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDisburseLoanLink() {
        return disburseLoanLink;
    }

    public void setDisburseLoanLink(String disburseLoanLink) {
        this.disburseLoanLink = disburseLoanLink;
    }

    public String getDenyLoanLink() {
        return denyLoanLink;
    }

    public void setDenyLoanLink(String denyLoanLink) {
        this.denyLoanLink = denyLoanLink;
    }
}
