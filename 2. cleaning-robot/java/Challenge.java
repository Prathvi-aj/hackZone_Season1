import com.financial.cleaningrobot.api.RobotApi;
import com.financial.cleaningrobot.api.RobotControl;

/**
 * Robot controller implementation
 */
public class Challenge {

    /**
     * The main entry point.
     * Don't change the code, besides the file path of the room layout.
     */
    public static void main(String[] args) throws Exception {
        RobotControl rc = new RobotControl("../resources/room-layout-1.txt");
        RobotApi api = rc.getRobotApi();
        cleanRooms(api);
        rc.evaluateResult();
    }

    /**
     * Add your implementation here.
     */
    private static void cleanRooms(RobotApi api) {
        while (true) {
            cleanCurrentRoom(api);

            if (!api.isBarrierAhead()) {
                api.move();
            } else {
                turnAround(api);
                if (api.isBarrierAhead()) {
                    break;
                } else {
                    api.move();
                }
            }
        }
    }

    private static void cleanCurrentRoom(RobotApi api) {
        while (!api.isBarrierAhead()) {
            api.move();
        }

        turnAround(api);

        if (!api.isBarrierAhead()) {
            api.move();
            turnAround(api);
        }
    }

    private static void turnAround(RobotApi api) {
        api.turnLeft();
        api.turnLeft();
    }

   
}
