package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Table(name = "i_region")
public class IRegion {
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "geoname_id",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String geoname_id;
    @Column(name = "locale_code",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String locale_code;
    @Column(name = "continent_code",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String continent_code;
    @Column(name = "continent_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String continent_name;
    @Column(name = "country_iso_code",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String country_iso_code;
    @Column(name = "country_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String country_name;
    @Column(name = "subdivision_1_iso_code",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String subdivision_1_iso_code;
    @Column(name = "subdivision_1_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String subdivision_1_name;
    @Column(name = "subdivision_2_iso_code",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String subdivision_2_iso_code;
    @Column(name = "subdivision_2_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String subdivision_2_name;
    @Column(name = "city_name",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String city_name;
    @Column(name = "metro_code",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String metro_code;
    @Column(name = "time_zone",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String time_zone;

    public String getGeoname_id() {
        return geoname_id;
    }

    public void setGeoname_id(String geoname_id) {
        this.geoname_id = geoname_id;
    }

    public String getLocale_code() {
        return locale_code;
    }

    public void setLocale_code(String locale_code) {
        this.locale_code = locale_code;
    }

    public String getContinent_code() {
        return continent_code;
    }

    public void setContinent_code(String continent_code) {
        this.continent_code = continent_code;
    }

    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    public String getCountry_iso_code() {
        return country_iso_code;
    }

    public void setCountry_iso_code(String country_iso_code) {
        this.country_iso_code = country_iso_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getSubdivision_1_iso_code() {
        return subdivision_1_iso_code;
    }

    public void setSubdivision_1_iso_code(String subdivision_1_iso_code) {
        this.subdivision_1_iso_code = subdivision_1_iso_code;
    }

    public String getSubdivision_1_name() {
        return subdivision_1_name;
    }

    public void setSubdivision_1_name(String subdivision_1_name) {
        this.subdivision_1_name = subdivision_1_name;
    }

    public String getSubdivision_2_iso_code() {
        return subdivision_2_iso_code;
    }

    public void setSubdivision_2_iso_code(String subdivision_2_iso_code) {
        this.subdivision_2_iso_code = subdivision_2_iso_code;
    }

    public String getSubdivision_2_name() {
        return subdivision_2_name;
    }

    public void setSubdivision_2_name(String subdivision_2_name) {
        this.subdivision_2_name = subdivision_2_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getMetro_code() {
        return metro_code;
    }

    public void setMetro_code(String metro_code) {
        this.metro_code = metro_code;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
