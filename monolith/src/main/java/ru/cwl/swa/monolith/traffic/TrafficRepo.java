package ru.cwl.swa.monolith.traffic;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor

@Repository
public class TrafficRepo {
    private final JdbcTemplate jdbcTemplate;

//    public void addTrafficItem(int objId, long time, float lat, float lon) {
//        final String insert = "INSERT INTO TRAFFIC(MON_ID,GMT_EVENT_TIME,LAT,LON) " +
//                "VALUES (?,?,?,?)";
//        jdbcTemplate.update(insert, objId, time, lat, lon);
//    }

    public void addTrafficItem(Traffic t) {
        final String insert = "INSERT INTO TRAFFIC(MON_ID,GMT_EVENT_TIME,LAT,LON) " +
                "VALUES (?,?,?,?)";
        jdbcTemplate.update(insert, t.getObjId(), t.getTime(), t.getLat(), t.getLon());
    }

    public List<Traffic> findByObjId(int objId, long from, long to) {
        String sql = "SELECT GMT_EVENT_TIME, MON_ID, LAT, LON " +
                "FROM TRAFFIC WHERE MON_ID=?AND GMT_EVENT_TIME>=?AND GMT_EVENT_TIME<?";
        Object[] args = {objId, from, to};
        return jdbcTemplate.query(sql, args, new RowMapper<Traffic>() {
            @Override
            public Traffic mapRow(ResultSet rs, int i) throws SQLException {
                return Traffic
                        .builder()
                        .objId(rs.getInt("MON_ID"))
                        .time(rs.getLong("GMT_EVENT_TIME"))
                        .lat(rs.getFloat("LAT"))
                        .lon(rs.getFloat("LON"))
                        .build();
            }
        });

    }
}
