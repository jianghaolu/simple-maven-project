import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.azure.management.resources.GenericResource;
import com.microsoft.rest.LogLevel;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Future;

/********************************************************************************************************
 * This sample does the following:
 *
 * 1) Starts a deployment of a virtual network, and tag the created resources with the deployment name.
 * 2) starts the same deployment, and tag the created (not updated) resources with the deployment name.
 * 3) Verifies that the virtual network only has the tag from the 1) deployment.
 ********************************************************************************************************/

public class Main {
    public static void main(String... args) throws Exception {

        Azure azure = Azure
                .configure()
                .withLogLevel(LogLevel.BASIC)
                .authenticate(new File(System.getenv("AZURE_AUTH_LOCATION")))
                .withDefaultSubscription();

        GenericResource searchResource = azure.genericResources()
                .get("javacsmrg319", "Microsoft.Storage", "storageAccounts", "teststoragejianghao");

        searchResource.update()
                .withTags(new HashMap<String, String>(){{ put("tag", "demo"); }})
                .apply();

        System.out.println(searchResource.id());


        Future<VirtualMachine> virtualMachineFuture =
    }
}
