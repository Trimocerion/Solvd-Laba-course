package threads;

public class Thread1 extends Thread{

    private final ConnectionPool connectionPool;

    public Thread1(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            String connection = connectionPool.getConnection();

            System.out.println(Thread.currentThread().getName() + " got " + connection);

            Thread.sleep(2000);

            connectionPool.releaseConnection(connection);
            System.out.println(Thread.currentThread().getName() + " released " + connection);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
