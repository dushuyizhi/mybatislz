package com.entity;

import com.enumpackage.StatusEnum;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author ZhengLiu
 * @since 2021-04-03
 */
@Data
public class McTxnIn  {

    private static final long serialVersionUID = 1L;

    private String id;
    private String merid;
    private String txnref;
    private String mernm;
    private String paytype;
    private String pmtoption;
    private String pmtchan;
    private String country;
    private String orgid;
    private String orgtxnref;
    private String txncry;
    private String txnamt;
    private String agtfee;
    private String hsbcfee;
    private String successurl;
    private String failurl;
    private String notifyurl;
    private String custfrstnm;
    private String custlastnm;
    private String custemail;
    private String custphone;
    private String description;
    private String txndate;
    private String txntime;
    private String rcvtime;
    private String reqtime;
    private String lastupdatetime;
    private OffsetDateTime createtime;
    private String paymentdatetime;
    private StatusEnum txnstatus;
    private String chkstatus;
    private String chkhubstatus;
    private String chkhubdate;
    private String batchno;
    private String errcode;
    private String errmsg;
    private String agttxnref;
    private String bankrefnum;
    private String brand;
    private String mcn;
    private String clientid;
    private String merchantkid;
    private String hsbckid;
    private String billingno;
    private String queryflag;
    private String rsv1;
    private String rsv2;
    private String rsv3;
    private String rsv4;
    private String rsv5;
    private String rsv6;
    private String rsv7;
    private String rsv8;
    private String rsv9;
    private String rsv10;
    private String chlflag;
    private String agtstatus;
    private String agtuniqueid;
    private String discount;
    private String addcharge;
    private String servicefee;
    private String servicetax;
    private String buyertxncry;
    private String buyertxnamt;
    private String netamt;
    private String cashback;
    private String gstfee;
    private String chkagtdate;
    private String feeflag;
    private String expiry;
    private String agtinvoiceid;
    private String orderamt;
    public McTxnIn(){}
    public McTxnIn(String id,String txnref,String merid,StatusEnum status, String country,OffsetDateTime createtime){
        this.merid = merid;
        this.txnref = txnref;
        this.country = country;
        this.createtime = createtime;
        this.id = id;
        this.txnstatus = status;
    }

}

