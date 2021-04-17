package com.class1;

import com.entity.McTxnIn;
import com.enumpackage.StatusEnum;
import com.mapper.McTxnInMapper;
import com.utils.OffSetDateTimeConverter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

public class InitMybatis {

    public static void main(String[] args) throws IOException {
        Init();
    }

    private static void Init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = null;
        try{
           sqlSession = sqlSessionFactory.openSession();
            McTxnInMapper mcTxnInMapper = sqlSession.getMapper(McTxnInMapper.class);
//            insert(mcTxnInMapper);
            select(mcTxnInMapper,"ORD_20210413000749");
        }finally {
            sqlSession.commit();//数据commit
            if(sqlSession != null) sqlSession.close();
        }
    }

    private static String insert(McTxnInMapper mcTxnInMapper) {
        String txnref = OffSetDateTimeConverter.parseDate(
                OffsetDateTime.now(),OffSetDateTimeConverter.YYYYDDMMHHSSMM);
        String id = "HSBC" + txnref;
        System.out.println(txnref);
        int i = mcTxnInMapper.insertTxn(
                new McTxnIn(id,"ORD_" + txnref,"EnOX7efXLhw9", StatusEnum.SUCCESS,"INHBAP",OffsetDateTime.now()));

        System.out.println("result = " + i);

        return txnref;
    }

    private static void select(McTxnInMapper mcTxnInMapper,String txnref) {
        McTxnIn mcTxnIn = mcTxnInMapper.selectByTxnref(txnref);
        System.out.println("mcTxnIn: " + mcTxnIn);


    }


}
