package uk.ac.ox.oucs.eidcsr.databankclient;

import com.sun.jersey.api.client.WebResource;
import java.util.Random;
import uk.ac.ox.its.databank.ws.restful.client.Datasets;
import uk.ac.ox.its.databank.ws.restful.client.Silos;
import uk.ac.ox.its.databank.ws.restful.client.States;
import uk.ac.ox.its.databank.ws.restful.client.WebResourceBuilder;

/**
 *
 * @author Asif Akram
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String argv[]) {
        Random randomGenerator = new Random();
                
        // http://163.1.127.173 is the actual URL for DataBank
        WebResource webResource = WebResourceBuilder.getInstance("http://163.1.127.173/", "userName", "password").getWebResource();

        /*
        1
        
        http://163.1.127.173/silos URL to get all Silos
         * in our case only EIDCSR will be returned
         */
        //new Silos().getAllSilosAsJSON(webResource);

        /*
         * ["eidcsr"]
         */
        System.out.println("Silos().getAllSilosAsJSON()");
        //new Silos().getAllSilosAsJSON(webResource);                          // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



        /*
        2
        
        http://163.1.127.173/silos URL to get all DataSets
         * in EIDCSR
         */
        //new Silos().getSiloAsHTML(webResource, "eidcsr");

        /*
         * Response: ["testAsifDS_1A", "newTestID1"]
         * Similar to http://localhost:7070/eidcsr/datasets
         */
        System.out.println("Silos().getSiloAsJSON(webResource, \"eidcsr\")");
        //new Silos().getSiloAsJSON(webResource, "eidcsr");                      // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




        /*
        3
         *
         *
         *
         * http://localhost:7070/eidcsr
         */
        webResource = webResource.path("eidcsr");
        //System.out.println(webResource.getURI().toString());

        /*
         * Response: ["testAsifDS_1A", "newTestID1"]
         * Similar to http://localhost:7070/eidcsr
         */
        //new Datasets().getAllDataSetsAsHTML(webResource, "datasets");

        /*
         * Response: ["testAsifDS_1A", "newTestID1"]
         * Similar to http://localhost:7070/eidcsr
         */
        System.out.println("Datasets().getAllDataSetsAsJSON(webResource, \"datasets\") in EIDCSR");
        //new Datasets().getAllDataSetsAsJSON(webResource, "datasets");          // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         *
         *
         * 4
         * It is working but not sure why Return Status is 500
         * An internal server error occurred
         */
        //new Datasets().createDataSet(webResource, "datasets", "AsifDataSet_2", "false", "2020-09-16", "Asif Test DataSet 2");  // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        //new Datasets().getDataSetAsHTML(webResource, "datasets", "AsifDataSet_3");

        System.out.println("Datasets().getDataSetAsJSON(webResource, \"datasets\", \"led_zip_unpack\")");
        new Datasets().getDataSetAsXML(webResource, "datasets", "led_zip_unpack");

        //new Datasets().getDataSetAsXML(webResource, "datasets", "AsifDataSet_3");

        //new Datasets().createDataSet(webResource, "datasets", "led_zip_unpack");    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         * 5
         *
         *
         * Status returned 200
         */
        System.out.println("Datasets().updateDataSet(webResource, \"datasets\", \"AsifDataSet_3\", \"false\", \"2019-07-28\", \"Asif Test DataSet 3\")");
        new Datasets().updateDataSet(webResource, "datasets", "AsifDataSet_3", "true", "2019-07-28", "Asif Test DataSet 3"); // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         * 6  Upload the Zipped File
         *
         * It is working but not sure why Return Status is 500
         * Now it return status 200
         * An internal server error occurred
         */
        System.out.println("Datasets().dataSetFileUpload(webResource, \"datasets\", \"AsifDataSet_\"+ randomGenerator.nextInt(100), \"/home/aassif/Downloads/jquery-ui-1.8.18.custom.zip\")");
        //new Datasets().dataSetFileUpload(webResource, "datasets", "AsifDataSet_"+ randomGenerator.nextInt(100), "/home/aassif/Downloads/jquery-ui-1.8.18.custom.zip"); // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         * 7
         *
         * Delete Resource
         * 
         * it return status 200
         */
        System.out.println("Datasets().deleteDataset(webResource, \"datasets\", \"AsifDataSet_\"+ randomGenerator.nextInt(100))");
        //new Datasets().deleteDataset(webResource, "datasets", "AsifDataSet_81");  // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        
        // This is not working
        // for this it is giving error 403 which is acceptable ...
        // I don't see even on form the option to upload files in subpath ...
        // not sure why it is there ...!
        //new Datasets().dataSetFileUploadWithSubPath(webResource, "datasets", "led_zip_unpack", "fileupload", "I:\\led.zip");

        //new Datasets().createDataSetWithSubPath(webResource, "datasets", "AsifDataSet_3", "asif_subPath");

        // new Datasets().deleteDataSetWithSubPath(webResource, "datasets", "AsifDataSet_4", "asif_subPath");

        //new Items().getItemsWithDatasetID(webResource, "newTestID1");


        /*
         * 8
         *
         * // Unpack the zipped file
         */

        //new Items().unpackFileWithDatasetID(webResource, "AsifDataSet_3", "led.zip", "led_zip_unpack_test"); // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        //new States().getStates(webResource);

        //new States().getStatesWithDatasetID(webResource, "led_zip_unpack_test");

    }
}
