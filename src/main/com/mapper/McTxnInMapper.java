package com.mapper;

import com.entity.McTxnIn;
import org.apache.ibatis.annotations.Select;

public interface McTxnInMapper {

    McTxnIn selectByTxnref(String txnref);

    @Select("select * from mc_txn_in where id = #{id}")
    McTxnIn selectById(String id);

    int insertTxn(McTxnIn mcTxnIn);
}
