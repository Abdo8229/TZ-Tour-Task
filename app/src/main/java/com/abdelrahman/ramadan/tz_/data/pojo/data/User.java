package com.abdelrahman.ramadan.tz_.data.pojo.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

public class User {


    public String getUserId() {
        return userId;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getRegionId() {
        return regionId;
    }

    public String getRegion() {
        return region;
    }

    public String getShortNumber() {
        return shortNumber;
    }

    @Attribute(name = "userId")
    String userId;

   @Element(name = "loginname")
    String loginname;

   @Element(name = "fullName")
   String fullName;

    @Element(name = "country")
    String country;

    @Element(name = "countryId")
    String countryId;

    @Element(name = "regionId",required = false)
    String regionId;

    @Element(name = "region", required = false)
    String region;

    @Element(name = "shortNumber", required = false)
    String shortNumber;


    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", loginname='" + loginname + '\'' +
                ", fullName='" + fullName + '\'' +
                ", country='" + country + '\'' +
                ", countryId='" + countryId + '\'' +
                ", regionId='" + regionId + '\'' +
                ", region='" + region + '\'' +
                ", shortNumber='" + shortNumber + '\'' +
                '}';
    }
}
