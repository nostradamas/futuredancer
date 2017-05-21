package com.fdw.util;

/**
 * 距离计算
 */
public class DistanceUtil {

	private static final double EARTH_RADIUS = 6378.137;

	
	//经度�? +- 0.05 表示 +- 5km 范围
	//纬度�? +- 0.05 表示 +- 5km 范围
	
	public static void main(String[] args) {
		System.out.println(getDistance(30.625011, 104.072701, 30.647363, 104.102209));
		System.out.println(getDistance(30.664385188806, 104.07559730274, 30.99301, 103.640709));
		System.out.println(getDistance(30.664385188806, 104.07559730274, 30.64303, 104.053817));

		System.out.println(getDistanceLL(30.65, 104.6000, 30.60, 104.60000));
	}
	
/*	 
 * 
 * <Latitude>39.981476</Latitude>
<Longitude>116.300522</Longitude>
<Precision>65.000000</Precision>
 * 
 * 或�?�用sql语句 计算获得距离
	SELECT *,
	ROUND(
		6378.138 * 2 * ASIN(
			SQRT(
				POW( SIN( ( 30.664385188806 * PI() / 180 - latitude * PI() / 180 ) / 2 ), 2 ) + 
				COS(30.664385188806 * PI() / 180) * COS(latitude * PI() / 180) * POW( SIN( ( 104.07559730274 * PI() / 180 - longitude * PI() / 180 ) / 2 ), 2 )
			)
		) * 1000
	) AS distance
FROM
	barber_shop
ORDER BY
	distance ;
	
	
	//可以限制多少范围内的
	SELECT * FROM (SELECT *,
	ROUND(
		6378.138 * 2 * ASIN(
			SQRT(
				POW( SIN( ( 30.664385188806 * PI() / 180 - latitude * PI() / 180 ) / 2 ), 2 ) + 
				COS(30.664385188806 * PI() / 180) * COS(latitude * PI() / 180) * POW( SIN( ( 104.07559730274 * PI() / 180 - longitude * PI() / 180 ) / 2 ), 2 )
			)
		) * 1000
	) AS distance
FROM
	barber_shop
ORDER BY
	distance

) as a WHERE a.distance <=5000
	
*/
	
	

	/**
	 * 计算两经纬度坐标的距�? 谷歌地图计算两个坐标点的距离函数
	 * 
	 * @param lat1
	 *            位置1 纬度
	 * @param lng1
	 *            位置1 经度
	 * 
	 * @param lat2
	 *            位置2 纬度
	 * @param lng2
	 *            位置2 经度
	 * @return 返回 距离 单位 �?
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double dLat = (lat2 - lat1) * Math.PI / 180;
		double dLng = (lng2 - lng1) * Math.PI / 180;
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1 * Math.PI / 180)
				* Math.cos(lat2 * Math.PI / 180) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = EARTH_RADIUS * 1000 * c;
		return Math.round(d);
	}

	/**
	 * 用GPS测出两个点的经纬度后
	 * 
	 * @param lat1
	 *            位置1 纬度
	 * @param lng1
	 *            位置1 经度
	 * 
	 * @param lat2
	 *            位置2 纬度
	 * @param lng2
	 *            位置2 经度
	 * @return 返回 距离 单位 �?
	 */
	public static double getDistanceLL(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS * 1000;
		return Math.round(s);
	}

	public static double rad(double d) {
		return d * Math.PI / 180.0;
	}

}
