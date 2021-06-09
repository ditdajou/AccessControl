package com.example.moneylion.repository;

import com.example.moneylion.model.ModifyAccessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;

import static org.apache.commons.lang3.StringUtils.SPACE;

@Repository
public class AccessControlRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean getAccessDetails(String email, String featureName) {
        boolean enableAccess = false;
        try {
            this.getAccessFeature(featureName);
            final String sql = "SELECT enable_access FROM feature_access WHERE email = ? AND feature_name = ? ";
            enableAccess = jdbcTemplate.queryForObject(sql, boolean.class, new Object[]{email, featureName});
        } catch (EmptyResultDataAccessException ex) {
            return enableAccess;
        }
        return enableAccess;
    }

    public List<ModifyAccessRequest> getAccessDetails() {
        final String sql = "SELECT * FROM feature_access LIMIT 1000";


        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(ModifyAccessRequest.class)
        );
        /*
        return jdbcTemplate.query(sql,
                new RowMapper<ModifyAccessRequest>() {
                    @Override
                    public ModifyAccessRequest mapRow(ResultSet rs, int i) throws SQLException {
                        ModifyAccessRequest record = new ModifyAccessRequest();

                        record.setFeatureName(rs.getString("feature_Name"));
                        record.setEmail(rs.getString("email"));
                        record.setEnable(rs.getBoolean("enable_access"));

                        return record;
                    }
                });
                */
    }

    private String getAccessFeature(String featureName) {
        final String sql = "SELECT feature_desc FROM feature_details WHERE feature_name = ?";
        return jdbcTemplate.queryForObject(sql, String.class, featureName);
    }

    public int modifyAccess(String featureName, String email, boolean isEnabled) {
        try {
            this.getAccessFeature(featureName);
        } catch (EmptyResultDataAccessException ex) {
            return 0;
        }
        final String sql = new StringJoiner(SPACE)
                .add("INSERT INTO feature_access")
                .add("(feature_name ,email, enable_access)")
                .add("VALUE (:feature_name,:email,:enable_access)")
                .add("ON DUPLICATE KEY UPDATE")
                .add("enable_access = :enable_access").toString();

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("feature_name", featureName);
        parameters.addValue("email", email);
        parameters.addValue("enable_access", isEnabled);

        return namedParameterJdbcTemplate.update(sql, parameters);
    }
}
