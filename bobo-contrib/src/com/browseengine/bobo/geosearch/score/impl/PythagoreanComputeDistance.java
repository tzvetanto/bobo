package com.browseengine.bobo.geosearch.score.impl;

public class PythagoreanComputeDistance extends HaversineComputeDistance {

	/**
     * {@inheritDoc}
     */
    @Override
    public float getDistanceInMiles(double longitudeInDegreesA, double latitudeInDegreesA,
    												double longitudeInDegreesB, double latitudeInDegreesB) {
    	double dlat = (latitudeInDegreesA - latitudeInDegreesB);
    	dlat = dlat * dlat;
    	double dlong = (longitudeInDegreesA - longitudeInDegreesB);
    	dlong = dlong * dlong;
    	// no need for Math.sqrt() since exact distance doesn't matter - the sort order
    	// with or without Math.sqrt() will be the same
    	float dist = (float)(dlat + dlong);
    	return dist;
    }
    
}
