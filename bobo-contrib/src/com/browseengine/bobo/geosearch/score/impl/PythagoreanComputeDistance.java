package com.browseengine.bobo.geosearch.score.impl;

public class PythagoreanComputeDistance extends HaversineComputeDistance {

	public static final double[] dLongTable =
		{
				// 0
				111319.491,
				// 10
				109639.322,
				// 20
				104646.931,
				// 30
				96485.974,
				// 40
				85393.409,
				// 50
				71695.220,
				// 60
				55799.470,
				// 70
				38186.113,
				// 80
				19393.247,
				// 90
				0
		};
		
	public static final double[] dLatTable =
		{
				// 0
				110574.389,
				// 10
				110611.187,
				// 20
				110710.615,
				// 30
				110860.926,
				// 40
				111044.261,
				// 50
				111238.681,
				// 60
				111420.728,
				// 70
				111568.259,
				// 80
				111663.201,
				// 90
				111693.865
		};
	
	/**
     * {@inheritDoc}
     */
    @Override
    public float getDistanceInMiles(double longitudeInDegreesA, double latitudeInDegreesA,
    												double longitudeInDegreesB, double latitudeInDegreesB) {
    	int index1 = Math.abs((int)(latitudeInDegreesA / 10));
		int index2 =  Math.abs((int)(latitudeInDegreesB / 10));
		double avgDlat = (dLatTable[index1] + dLatTable[index2]) / 2;
		double avgDlong = (dLongTable[index1] + dLongTable[index2]) / 2;
		
    	double dlat = (latitudeInDegreesA - latitudeInDegreesB) * avgDlat;
    	dlat = dlat * dlat;
    	double dlong = (longitudeInDegreesA - longitudeInDegreesB) * avgDlong;
    	dlong = dlong * dlong;
    	float dist = (float)(Math.sqrt(dlat + dlong) / 1609.344);
    	return dist;
    }
    
}
