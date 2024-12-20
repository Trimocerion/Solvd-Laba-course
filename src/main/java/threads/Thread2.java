package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Thread2 implements Runnable {

    private final ConnectionPool connectionPool;


    public Thread2(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        getConnectionAsync()
                .thenCompose(connection -> performTaskWithConnectionAsync(connection)
                        .thenApply(v -> connection))
                .thenAccept(this::releaseConnectionAsync)
                .exceptionally(ex -> {
                    System.err.println("Error in thread execution: " + ex.getMessage());
                    return null;
                });
    }

    private CompletableFuture<String> getConnectionAsync() {
        return connectionPool.getConnectionFuture();
    }

    private CompletableFuture<Void> performTaskWithConnectionAsync(String connection) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " got " + connection);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task interrupted", e);
            }
        });
    }

    private void releaseConnectionAsync(String connection) {
        CompletableFuture.runAsync(() -> {
            connectionPool.releaseConnection(connection);
            System.out.println(Thread.currentThread().getName() + " released " + connection);
        });
    }


}

