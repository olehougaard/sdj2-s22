package dk.via.protokol;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClientImplementation("localhost", 8888);
        System.out.println(client.echo("Hello"));
        System.out.println(client.echo("Goodbye"));
        System.out.println(client.echo("close"));
        System.out.println(client.echo("echo"));
        client.close();
    }
}
