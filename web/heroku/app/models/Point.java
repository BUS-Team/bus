package models;

import java.sql.Timestamp;

/**
 *
 * @author breno
 */

public class Point {
    private Integer id;
    private Integer line;
    private String  direction;
    private Float  lat;
    private Float  lng;
    private Integer sequence;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setLine(Integer line) {
        this.line = line;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public void setLat(Float  lat) {
        this.lat = lat;
    }
    public void setLng(Float  lng) {
        this.lng = lng;
    }
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }


    public Integer getId() {
        return this.id;
    }
    public Integer getLine() {
        return this.line;
    }
    public String getDirection() {
        return this.direction;
    }
    public Float  getLat() {
        return this.lat;
    }
    public Float  getLng() {
        return this.lng;
    }
    public Integer getSequence() {
        return this.sequence;
    }
} 