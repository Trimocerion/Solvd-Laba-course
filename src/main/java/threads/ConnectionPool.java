package threads;

import java.util.concurrent.*;

public class ConnectionPool {

    private static ConnectionPool instance;
    private final BlockingQueue<String> connections;

    private ConnectionPool(int size){
        connections = new LinkedBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            connections.add("Connection-" + (i + 1));
        }
    }

    public static synchronized ConnectionPool getInstance(int size){
        if (instance == null){
            instance = new ConnectionPool(size);
        }
        return instance;
    }


    public String getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(String connection) {
        connections.add(connection);
    }

    public CompletableFuture<String> getConnectionFuture(){
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return connections.take();
                    }
                    catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                        return null;
                    }
                });
    }
}
