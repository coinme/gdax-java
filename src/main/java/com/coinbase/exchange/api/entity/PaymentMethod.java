package com.coinbase.exchange.api.entity;

/**
 * @author msmyers
 * @since 11/24/16
 */
public class PaymentMethod {

    private String id;
    private String type;
    private String name;
    private String currency;
    private boolean primaryBuy;
    private boolean primarySell;

    private boolean allowSell;
    private boolean allowBuy;
    private boolean allowDeposit;
    private boolean allowWithdraw;

    private PaymentMethodLimit limits;

//    {
//        "id":"bc6d7162-d984-5ffa-963c-a493b1c1370b",
//        "type":"ach_bank_account",
//        "name":"Bank of America - eBan... ********7134",
//        "currency":"USD",
//        "primary_buy":true,
//        "primary_sell":true,
//        "allow_buy":true,
//        "allow_sell":true,
//        "allow_deposit":true,
//        "allow_withdraw":true,
//        "limits":{
//              "buy":[{
//                  "period_in_days":1,
//                  "total":{
//                      "amount":"10000.00",
//                      "currency":"USD"
//                   },
//                  "remaining":{
//                      "amount":"10000.00",
//                      "currency":"USD"
//                  }
//              }],
//          }
//    },


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isPrimaryBuy() {
        return primaryBuy;
    }

    public void setPrimaryBuy(boolean primaryBuy) {
        this.primaryBuy = primaryBuy;
    }

    public boolean isPrimarySell() {
        return primarySell;
    }

    public void setPrimarySell(boolean primarySell) {
        this.primarySell = primarySell;
    }

    public boolean isAllowSell() {
        return allowSell;
    }

    public void setAllowSell(boolean allowSell) {
        this.allowSell = allowSell;
    }

    public boolean isAllowBuy() {
        return allowBuy;
    }

    public void setAllowBuy(boolean allowBuy) {
        this.allowBuy = allowBuy;
    }

    public boolean isAllowDeposit() {
        return allowDeposit;
    }

    public void setAllowDeposit(boolean allowDeposit) {
        this.allowDeposit = allowDeposit;
    }

    public boolean isAllowWithdraw() {
        return allowWithdraw;
    }

    public void setAllowWithdraw(boolean allowWithdraw) {
        this.allowWithdraw = allowWithdraw;
    }

    public PaymentMethodLimit getLimits() {
        return limits;
    }

    public void setLimits(PaymentMethodLimit limits) {
        this.limits = limits;
    }
}
