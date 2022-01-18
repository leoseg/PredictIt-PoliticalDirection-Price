package com.webpage.predictpoliticalpartyprice.mapper;

import com.webpage.predictpoliticalpartyprice.entities.ContractLog;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;

@Component
public class ContractLogRowMapper implements RowMapper<ContractLog> {

    @Override
    public ContractLog mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContractLog contractLog = new ContractLog();
        contractLog.setTimestamp(rs.getTimestamp(2).toInstant().plus(1, ChronoUnit.HOURS));
        contractLog.setTradePrice(rs.getDouble(1));
        return contractLog;
    }
}
