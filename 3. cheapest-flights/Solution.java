import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Test case 1
        int[][] flights1 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println("Actual: " + findCheapestPrice(4, flights1, 0, 3, 1) + ", Expected: 700");

        // Test case 2
        int[][] flights2 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println("Actual: " + findCheapestPrice(4, flights2, 0, 3, 0) + ", Expected: -1");

        // Test case 3
        int[][] flights3 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println("Actual: " + findCheapestPrice(3, flights3, 0, 2, 0) + ", Expected: 500");
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // add your solution here
    	
    	Map<String, Integer> flightMap = new HashMap<>();

        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int value = flight[2];

            String key = source + "-" + destination;
            flightMap.put(key, value);
        }
    
    	
    	if(k==0 && flightMap.containsKey(src+"-"+dst)) {
    		return flightMap.get(src+"-"+dst);
    	}
    	else if(k>0){
    		int flightMinPrice=0;
    		for (Map.Entry<String, Integer> entry : flightMap.entrySet()) {
    			if(k==-1) {
    				break;
    			}
    			if(Integer.parseInt(entry.getKey().substring(0,1))==src) {
    				if(k!=0) {
    					flightMinPrice+=entry.getValue();
    				}
    				else if(flightMap.containsKey(src+"-"+dst) && k==0){
    					flightMinPrice+=flightMap.get(src+"-"+dst);
    					
    				}
    				src=Integer.parseInt(entry.getKey().substring(entry.getKey().length()-1,entry.getKey().length()));
    				k--;
    			}
                
            }
    		return flightPrice;
    		
    	}
    	
    	
    	return -1;
    	
    	
    }
}