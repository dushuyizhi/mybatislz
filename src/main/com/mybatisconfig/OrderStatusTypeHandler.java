package com.mybatisconfig;

import com.enumpackage.StatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@MappedJdbcTypes(JdbcType.VARCHAR)
//@MappedTypes(StatusEnum.class)
public class OrderStatusTypeHandler extends BaseTypeHandler<StatusEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, StatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,StatusEnum.parseValue(parameter.getValue()));
    }

    @Override
    public StatusEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {

        return StatusEnum.getEmpStatusByCode(rs.getString(columnName));
    }


    @Override
    public StatusEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return StatusEnum.getEmpStatusByCode(rs.getString(columnIndex));
    }


    @Override
    public StatusEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return StatusEnum.getEmpStatusByCode(cs.getString(columnIndex));
    }
}
