package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ConnectionPool pool = ConnectionPool.getInstance(5);
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for(int i = 0; i < 7 ; i++){
//            executorService.submit(new Thread(new Thread2(pool)));
            executorService.submit(new Thread1(pool));
        }
        executorService.shutdown();
    }
}
