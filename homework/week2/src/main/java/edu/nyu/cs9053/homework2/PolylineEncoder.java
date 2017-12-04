package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:02 AM
 *
 * Implements the Polyline Algorithm defined here
 * {@literal https://developers.google.com/maps/documentation/utilities/polylinealgorithm}
 */
public class PolylineEncoder {

	public  String encodePolyline(Gps[] gps) {
        String encodedGps = "";
        double lastLatitude = 0;
		double lastLongitude = 0;
		try{
			for(Gps g : gps){
			double latitudeChange = g.getLatitude() - lastLatitude;
				lastLatitude = g.getLatitude();
				double longitudeChange = g.getLongitude() - lastLongitude;
				lastLongitude = g.getLongitude();
				encodedGps += encode(latitudeChange)+encode(longitudeChange);
			}
		}
		catch (NullPointerException e){
				return "Invalid argument";
			}
		return encodedGps;
    }
	
	public static String encode(double original){
		int oriInE5 = (int)(original*Math.pow(10,5));
		int changeOri = oriInE5 << 1;
		if(original<0) changeOri = ~changeOri;
		
		int[] chunks = new int[7];
		String encodedGps = "";
		for(int i = 0;i < 7;i++){
			chunks[i] = changeOri & 31;
			changeOri >>= 5;
		}
		int chunkEnd = 6;
		while(chunks[chunkEnd] == 0){
			chunkEnd --;
		}
		for(int i = 0; i < chunkEnd;i++){
			chunks[i] ^= 0x20;
		}
		for(int i = 0;i <= chunkEnd; i++){
			if(chunks[i] == 0) continue;
			chunks[i] += 63;			
			encodedGps += (char)chunks[i];
		}		
		return encodedGps;
	}	



}
