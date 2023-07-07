package com.abdelrahman.ramadan.tz_.data.pojo.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "task")

public class TasksResponse {

    @Element(name = "rideId", required = false)
    String rideId;
    @Element(name = "startLocation", required = false)
    String startLocation;
    @Element(name = "endLocation", required = false)
    String endLocation;
    @Element(name = "serviceId", required = false)
    String serviceId;
    @Element(name = "rideType", required = false)
    String rideType;
    @Element(name = "rideTypeId", required = false)
    String rideTypeId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "TestResponse{" +
                "rideId='" + rideId + '\'' +
                ", startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", rideType='" + rideType + '\'' +
                ", rideTypeId='" + rideTypeId + '\'' +
                ", brandId=" + brandId +
                ", transferType='" + transferType + '\'' +
                ", rideStatus='" + rideStatus + '\'' +
                ", transferTypeId='" + transferTypeId + '\'' +
                ", note='" + note + '\'' +
                ", driverId='" + driverId + '\'' +
                ", driver='" + driver + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", govermentNumber='" + govermentNumber + '\'' +
                ", internalNumber='" + internalNumber + '\'' +
                ", vehicleCategoryId='" + vehicleCategoryId + '\'' +
                ", vehicleCategory='" + vehicleCategory + '\'' +
                ", regionId='" + regionId + '\'' +
                ", region='" + region + '\'' +
                ", workDate='" + workDate + '\'' +
                ", guideId='" + guideId + '\'' +
                ", guide='" + guide + '\'' +
                ", country='" + country + '\'' +
                ", countryId='" + countryId + '\'' +
                ", startLocationName='" + startLocationName + '\'' +
                ", endLocationName='" + endLocationName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pax='" + pax + '\'' +
                ", adult='" + adult + '\'' +
                ", child='" + child + '\'' +
                ", infant='" + infant + '\'' +
                ", minStartTime='" + minStartTime + '\'' +
                ", maxStartTime='" + maxStartTime + '\'' +
                ", meetingPointNote='" + meetingPointNote + '\'' +
                ", guidePhone='" + guidePhone + '\'' +
                ", guideTableNo='" + guideTableNo + '\'' +
                ", meetingPointTime='" + meetingPointTime + '\'' +
                ", startLocationRegion='" + startLocationRegion + '\'' +
                ", endLocationRegionId='" + endLocationRegionId + '\'' +
                ", endLocationRegion='" + endLocationRegion + '\'' +
                ", shuttleType='" + shuttleType + '\'' +
                ", shuttleMainRide='" + shuttleMainRide + '\'' +
                ", shuttleBackRide='" + shuttleBackRide + '\'' +
                ", importanceType='" + importanceType + '\'' +
                ", subRide='" + subRide + '\'' +
                ", flightDepartureId='" + flightDepartureId + '\'' +
                ", selfTransfer='" + selfTransfer + '\'' +
                ", driverPhone='" + driverPhone + '\'' +
                ", meetingPoint='" + meetingPoint + '\'' +
                ", guideShortNumber='" + guideShortNumber + '\'' +
                ", vehicleCapacity='" + vehicleCapacity + '\'' +
                ", secondGuideId='" + secondGuideId + '\'' +
                ", secondGuide='" + secondGuide + '\'' +
                ", secondGuidePhone='" + secondGuidePhone + '\'' +
                ", secondGuideShortNumber='" + secondGuideShortNumber + '\'' +
                ", secondGuideTableNo='" + secondGuideTableNo + '\'' +
                ", vehicleCompany='" + vehicleCompany + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", route='" + route + '\'' +
                ", vehicleCategory1='" + vehicleCategory1 + '\'' +
                ", defaultMeatingPlace='" + defaultMeatingPlace + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", ikamataNumber='" + ikamataNumber + '\'' +
                ", paul='" + paul + '\'' +
                ", vehicleEndTime='" + vehicleEndTime + '\'' +
                ", vehicleInfo='" + vehicleInfo + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", driverShortNumber='" + driverShortNumber + '\'' +
                ", startLocationRegionId='" + startLocationRegionId + '\'' +
                '}';
    }

    @Element(name = "brandId", required = false)
    int brandId;
    @Element(name = "transferType", required = false)
    String transferType;

    public String getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(String rideStatus) {
        this.rideStatus = rideStatus;
    }

    @Element(name = "rideStatus", required = false)
    String rideStatus;

    @Element(name = "transferTypeId", required = false)
    String transferTypeId;
    @Element(name = "note", required = false)
    String note;
    @Element(name = "driverId", required = false)
    String driverId;
    @Element(name = "driver", required = false)
    String driver;
    @Element(name = "vehicleId", required = false)
    String vehicleId;
    @Element(name = "govermentNumber", required = false)
    String govermentNumber;
    @Element(name = "internalNumber", required = false)
    String internalNumber;
    @Element(name = "vehicleCategoryId", required = false)
    String vehicleCategoryId;
    @Element(name = "vehicleCategory", required = false)
    String vehicleCategory;
    @Element(name = "regionId", required = false)
    String regionId;
    @Element(name = "region", required = false)
    String region;
    @Element(name = "workDate", required = false)
    String workDate;
    @Element(name = "guideId", required = false)
    String guideId;
    @Element(name = "guide", required = false)
    String guide;
    @Element(name = "country", required = false)
    String country;
    @Element(name = "countryId", required = false)
    String countryId;
    @Element(name = "startLocationName", required = false)
    String startLocationName;
    @Element(name = "endLocationName", required = false)
    String endLocationName;
    @Element(name = "startTime", required = false)
    String startTime;
    @Element(name = "endTime", required = false)
    String endTime;
    @Element(name = "pax", required = false)
    String pax;
    @Element(name = "adult", required = false)
    String adult;
    @Element(name = "child", required = false)
    String child;
    @Element(name = "infant", required = false)
    String infant;
    @Element(name = "minStartTime", required = false)
    String minStartTime;
    @Element(name = "maxStartTime", required = false)
    String maxStartTime;
    @Element(name = "meetingPointNote", required = false)
    String meetingPointNote;
    @Element(name = "guidePhone", required = false)
    String guidePhone;
    @Element(name = "guideTableNo", required = false)
    String guideTableNo;
    @Element(name = "meetingPointTime", required = false)
    String meetingPointTime;
    @Element(name = "startLocationRegion", required = false)
    String startLocationRegion;
    @Element(name = "endLocationRegionId", required = false)
    String endLocationRegionId;
    @Element(name = "endLocationRegion", required = false)
    String endLocationRegion;
    @Element(name = "shuttleType", required = false)
    String shuttleType;
    @Element(name = "shuttleMainRide", required = false)
    String shuttleMainRide;
    @Element(name = "shuttleBackRide", required = false)
    String shuttleBackRide;
    @Element(name = "importanceType", required = false)
    String importanceType;
    @Element(name = "subRide", required = false)
    String subRide;
    @Element(name = "flightDepartureId", required = false)
    String flightDepartureId;
    @Element(name = "selfTransfer", required = false)
    String selfTransfer;
    @Element(name = "driverPhone", required = false)
    String driverPhone;
    @Element(name = "meetingPoint", required = false)
    String meetingPoint;
    @Element(name = "guideShortNumber", required = false)
    String guideShortNumber;
    @Element(name = "vehicleCapacity", required = false)
    String vehicleCapacity;
    @Element(name = "secondGuideId", required = false)
    String secondGuideId;
    @Element(name = "secondGuide", required = false)
    String secondGuide;
    @Element(name = "secondGuidePhone", required = false)
    String secondGuidePhone;
    @Element(name = "secondGuideShortNumber", required = false)
    String secondGuideShortNumber;
    @Element(name = "secondGuideTableNo", required = false)
    String secondGuideTableNo;
    @Element(name = "vehicleCompany", required = false)
    String vehicleCompany;
    @Element(name = "arrivalAirport", required = false)
    String arrivalAirport;
    @Element(name = "departureAirport", required = false)
    String departureAirport;
    @Element(name = "groupCode", required = false)
    String groupCode;
    @Element(name = "route", required = false)
    String route;
    @Element(name = "vehicleCategory1", required = false)
    String vehicleCategory1;
    @Element(name = "defaultMeatingPlace", required = false)
    String defaultMeatingPlace;
    @Element(name = "passportNumber", required = false)
    String passportNumber;
    @Element(name = "ikamataNumber", required = false)
    String ikamataNumber;
    @Element(name = "paul", required = false)
    String paul;
    @Element(name = "vehicleEndTime", required = false)
    String vehicleEndTime;
    @Element(name = "vehicleInfo", required = false)
    String vehicleInfo;
    @Element(name = "flightNumber", required = false)
    String flightNumber;
    @Element(name = "driverShortNumber", required = false)
    String driverShortNumber;
    @Element(name = "startLocationRegionId", required = false)
    String startLocationRegionId;

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public String getRideTypeId() {
        return rideTypeId;
    }

    public void setRideTypeId(String rideTypeId) {
        this.rideTypeId = rideTypeId;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(String transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getGovermentNumber() {
        return govermentNumber;
    }

    public void setGovermentNumber(String govermentNumber) {
        this.govermentNumber = govermentNumber;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(String vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStartLocationName() {
        return startLocationName;
    }

    public void setStartLocationName(String startLocationName) {
        this.startLocationName = startLocationName;
    }

    public String getEndLocationName() {
        return endLocationName;
    }

    public void setEndLocationName(String endLocationName) {
        this.endLocationName = endLocationName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPax() {
        return pax;
    }

    public void setPax(String pax) {
        this.pax = pax;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getInfant() {
        return infant;
    }

    public void setInfant(String infant) {
        this.infant = infant;
    }

    public String getMinStartTime() {
        return minStartTime;
    }

    public void setMinStartTime(String minStartTime) {
        this.minStartTime = minStartTime;
    }

    public String getMaxStartTime() {
        return maxStartTime;
    }

    public void setMaxStartTime(String maxStartTime) {
        this.maxStartTime = maxStartTime;
    }

    public String getMeetingPointNote() {
        return meetingPointNote;
    }

    public void setMeetingPointNote(String meetingPointNote) {
        this.meetingPointNote = meetingPointNote;
    }

    public String getGuidePhone() {
        return guidePhone;
    }

    public void setGuidePhone(String guidePhone) {
        this.guidePhone = guidePhone;
    }

    public String getGuideTableNo() {
        return guideTableNo;
    }

    public void setGuideTableNo(String guideTableNo) {
        this.guideTableNo = guideTableNo;
    }

    public String getMeetingPointTime() {
        return meetingPointTime;
    }

    public void setMeetingPointTime(String meetingPointTime) {
        this.meetingPointTime = meetingPointTime;
    }

    public String getStartLocationRegion() {
        return startLocationRegion;
    }

    public void setStartLocationRegion(String startLocationRegion) {
        this.startLocationRegion = startLocationRegion;
    }

    public String getEndLocationRegionId() {
        return endLocationRegionId;
    }

    public void setEndLocationRegionId(String endLocationRegionId) {
        this.endLocationRegionId = endLocationRegionId;
    }

    public String getShuttleType() {
        return shuttleType;
    }

    public void setShuttleType(String shuttleType) {
        this.shuttleType = shuttleType;
    }

    public String getShuttleMainRide() {
        return shuttleMainRide;
    }

    public void setShuttleMainRide(String shuttleMainRide) {
        this.shuttleMainRide = shuttleMainRide;
    }

    public String getShuttleBackRide() {
        return shuttleBackRide;
    }

    public void setShuttleBackRide(String shuttleBackRide) {
        this.shuttleBackRide = shuttleBackRide;
    }

    public String getImportanceType() {
        return importanceType;
    }

    public void setImportanceType(String importanceType) {
        this.importanceType = importanceType;
    }

    public String getSubRide() {
        return subRide;
    }

    public void setSubRide(String subRide) {
        this.subRide = subRide;
    }

    public String getFlightDepartureId() {
        return flightDepartureId;
    }

    public void setFlightDepartureId(String flightDepartureId) {
        this.flightDepartureId = flightDepartureId;
    }

    public String getSelfTransfer() {
        return selfTransfer;
    }

    public void setSelfTransfer(String selfTransfer) {
        this.selfTransfer = selfTransfer;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public String getGuideShortNumber() {
        return guideShortNumber;
    }

    public void setGuideShortNumber(String guideShortNumber) {
        this.guideShortNumber = guideShortNumber;
    }

    public String getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(String vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getSecondGuideId() {
        return secondGuideId;
    }

    public void setSecondGuideId(String secondGuideId) {
        this.secondGuideId = secondGuideId;
    }

    public String getSecondGuide() {
        return secondGuide;
    }

    public void setSecondGuide(String secondGuide) {
        this.secondGuide = secondGuide;
    }

    public String getSecondGuidePhone() {
        return secondGuidePhone;
    }

    public void setSecondGuidePhone(String secondGuidePhone) {
        this.secondGuidePhone = secondGuidePhone;
    }

    public String getSecondGuideShortNumber() {
        return secondGuideShortNumber;
    }

    public void setSecondGuideShortNumber(String secondGuideShortNumber) {
        this.secondGuideShortNumber = secondGuideShortNumber;
    }

    public String getSecondGuideTableNo() {
        return secondGuideTableNo;
    }

    public void setSecondGuideTableNo(String secondGuideTableNo) {
        this.secondGuideTableNo = secondGuideTableNo;
    }

    public String getVehicleCompany() {
        return vehicleCompany;
    }

    public void setVehicleCompany(String vehicleCompany) {
        this.vehicleCompany = vehicleCompany;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getVehicleCategory1() {
        return vehicleCategory1;
    }

    public void setVehicleCategory1(String vehicleCategory1) {
        this.vehicleCategory1 = vehicleCategory1;
    }

    public String getDefaultMeatingPlace() {
        return defaultMeatingPlace;
    }

    public void setDefaultMeatingPlace(String defaultMeatingPlace) {
        this.defaultMeatingPlace = defaultMeatingPlace;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIkamataNumber() {
        return ikamataNumber;
    }

    public void setIkamataNumber(String ikamataNumber) {
        this.ikamataNumber = ikamataNumber;
    }

    public String getPaul() {
        return paul;
    }

    public void setPaul(String paul) {
        this.paul = paul;
    }

    public String getVehicleEndTime() {
        return vehicleEndTime;
    }

    public void setVehicleEndTime(String vehicleEndTime) {
        this.vehicleEndTime = vehicleEndTime;
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
}
