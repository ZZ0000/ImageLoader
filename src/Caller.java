import java.util.ArrayList;

/**
 * Created by semeykin on 20.10.2016.
 */
public class Caller implements ImageLoader.Callback {
        private ArrayList<String> statuses = new ArrayList<>();

        public ArrayList<String> getStatuses() {
            return statuses;
        }

    @Override
    public void callingBack(String status) {
        synchronized (statuses) {
            statuses.add(status);
        }
    }
}

