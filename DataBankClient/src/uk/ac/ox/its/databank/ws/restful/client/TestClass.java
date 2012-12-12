package uk.ac.ox.its.databank.ws.restful.client;

import com.sun.jersey.api.client.WebResource;
import java.util.Random;

/**
 *
 * @author Asif Akram
 */
public class TestClass {

    public static void main(String argv[]) {
        
         Random randomGenerator = new Random();
         
        // http://163.1.127.173 is the actual URL for DataBank
        WebResource webResource = WebResourceBuilder.getInstance("http://163.1.127.173"/*"http://localhost:7070/"*/, "userName", "password").getWebResource();

        /*
         1

         http://163.1.127.173/silos URL to get all Silos
         * in our case only EIDCSR will be returned
         * Now it returns list of all silos
         */
        //new Silos().getAllSilosAsHTML(webResource);

        /*
         * ["eidcsr", "BehaviouralEcology", "admiral", "admiral-test", "Development"]
         */
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
         // new Datasets().getAllDataSetsAsJSON(webResource, "datasets");          // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         *
         *
         * 4
         * It is working but not sure why Return Status is 302
         * URL redirection
         */
        //new Datasets().createDataSet(webResource, "datasets", "AsifDataSet_asdf", "false", "2020-01-21", "Asif Test DataSet for testing");  // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         * 
         * Method to get contents of dataset in various formats
         * 
         * 
         */
        //new Datasets().getDataSetAsHTML(webResource, "datasets", "AsifDataSet_asdf");

        //new Datasets().getDataSetAsJSON(webResource, "datasets", "AsifDataSet_3");

        //new Datasets().getDataSetAsXML(webResource, "datasets", "AsifDataSet_asdf");
        
        
        /*
         * 
         * Method to create empty dataset wtih default information
         * 
         * 
         */
        //new Datasets().createDataSet(webResource, "datasets", "DemoDataSet_4");    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         * 5
         *
         * Updates the metadata related to Dataset
         * Status returned 200
         */
        //new Datasets().updateDataSet(webResource, "datasets", "DemoDataSet_4", "true", "2029-09-16", "Demo Test DataSet 4"); // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         * 6  Upload the Zipped File in the root of dataset
         *
         * It is working with Return Status 200
         * 
         */
         //new Datasets().dataSetFileUpload(webResource, "datasets", "AsifDataSet_"+ randomGenerator.nextInt(100), "/home/aassif/Downloads/jquery-ui-1.8.18.custom.zip"); // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

         /*
         * 6  Upload the Zipped File with the path
         *    all directories will be created along this process
         * It is working with Return Status 200
         * 
         */
        //new Datasets().dataSetFileUploadWithSubPath(webResource, "datasets", "AsifDataSet_64", "/asiff/subPathh/s45s", "/home/aassif/Downloads/jquery-ui-1.8.18.custom.zip");
        
        /*
         * 7
         *
         * Delete Resource
         */
        new Datasets().deleteDataset(webResource, "datasets", "AsifDataSet_64");  // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        // This is not working
        // for this it is giving error 403 which is acceptable ...
        // I don't see even on form the option to upload files in subpath ...
        // not sure why it is there ...!
        //new Datasets().dataSetFileUploadWithSubPath(webResource, "datasets", "led_zip_unpack", "fileupload", "I:\\led.zip");

        //new Datasets().createDataSetWithSubPath(webResource, "datasets", "AsifDataSet_4", "asif_subPath");

        // new Datasets().deleteDataSetWithSubPath(webResource, "datasets", "AsifDataSet_4", "asif_subPath");

       


        /*
         * 8
         *
         * Unpack the zipped file
         * creates new dataset the parameter after zipped file name is used as new dataset
         *
         */     
        //new Items().unpackFileWithDatasetID(webResource, "AsifDataSet_3", "led.zip", "led_zip_unpack_test_45"); // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        /*
         * 9
         * 
         * Returns list of zipped files in the dataset
         * 
         */    
         //new Items().getItemsWithDatasetID(webResource, "AsifDataSet_3");
         
         //new Items().unpackFileWithDatasetWithSubPathID(webResource, "AsifDataSet_3", "/", "led.zip", "led_zip_unpack_test_45A");
        
        //new Items().getDataSetWithSubPathAsHTML(webResource, "AsifDataSet_3", "abcd");
        
        //new States().getStates(webResource);

        //new States().getStatesWithDatasetID(webResource, "led_zip_unpack_test");

    }
}
