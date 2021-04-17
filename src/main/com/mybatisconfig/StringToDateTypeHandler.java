package com.mybatisconfig;

import com.utils.OffSetDateTimeConverter;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * 必须继承BaseTypeHandler 或者实现 TypeHandler接口
 * 加了下面连个注解之后就不用在xml里面写jdbctyoe 和 javatype了
 */
//@MappedJdbcTypes({JdbcType.VARCHAR})
//@MappedTypes({OffsetDateTime.class})
public class StringToDateTypeHandler extends BaseTypeHandler<OffsetDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OffsetDateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,OffSetDateTimeConverter.parseDate(parameter, OffSetDateTimeConverter.YYYYDDMM_HH_SS_MM));
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {

        return OffSetDateTimeConverter.convertDateTime(rs.getString(columnName),OffSetDateTimeConverter.YYYYDDMM_HH_SS_MM);
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return OffSetDateTimeConverter.convertDateTime(rs.getString(columnIndex),OffSetDateTimeConverter.YYYYDDMM_HH_SS_MM);
    }

    @Override
    public OffsetDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return OffSetDateTimeConverter.convertDateTime(cs.getString(columnIndex),OffSetDateTimeConverter.YYYYDDMM_HH_SS_MM);
    }
}
