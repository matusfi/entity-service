package sk.laslofi.entityService;

import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;


public class App {
    public static void main(String[] args) {
        ServiceEndpointServer server = new EndpointServerBuilder().build();
        server.initServices(new EntityService());
        server.start();
    }
}