// versions would be a 1D array with either '0' or '1' as its elements.
// '0' indicates the version is bug-free and '1' indicates the version is buggy.
// (Ex - For input [0, 0, 1, 1, 1], the bug was introduced in version 2 and the function should return 1)

public class Challenge {
    /**
     * The main entry point.
     * Don't change the code, besides the input to the function.
     */
    public static void main(String[] args) throws Exception {
        lastBugFreeVersion(new int[]{0, 0, 1, 1, 1});
    }

    public static int lastBugFreeVersion(int[] versions) {
        // Your implementation here
    	for(int i=versions.length-1;i>=0;i--) {
    		if(versions[i]==0) {
    			return i;
    		}
    	}
    	System.out.println("All versions are Buggy");
    	return -1;
    }
}