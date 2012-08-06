/**
 * 
 */
package com.browseengine.bobo.geosearch;

import java.util.Map;

import com.browseengine.bobo.geosearch.bo.CartesianCoordinate;
import com.browseengine.bobo.geosearch.bo.GeoRecord;
import com.browseengine.bobo.geosearch.bo.LatitudeLongitudeDocId;

/**
 * @author Ken McCracken
 *
 */
    public interface IGeoConverter {
        LatitudeLongitudeDocId toLongitudeLatitudeDocId(GeoRecord geoRecord);
        GeoRecord toGeoRecord(IFieldNameFilterConverter fieldNameFilterConverter, 
                String fieldName, LatitudeLongitudeDocId longitudeLatitudeDocId);
        GeoRecord toGeoRecord(byte filterByte, LatitudeLongitudeDocId longitudeLatitudeDocId);
        IFieldNameFilterConverter makeFieldNameFilterConverter();
        void addFieldBitMask(String fieldName, byte bitMask);
        void setFieldToBitmaskMapping(Map<String, Byte> mapping);
        
        CartesianCoordinate toCartesianCoordinate(double latitude, double longitude);
    }
