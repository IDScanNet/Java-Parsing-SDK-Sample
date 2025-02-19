package com.idscan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.EnumSet;

import net.idscan.parsers.DLParser;
import net.idscan.parsers.IdentityCardPresenter;
import net.idscan.parsers.ParserResult;
import net.idscan.parsers.ValidationError;
import net.idscan.parsers.ValidationStrictnessLevel;
import net.idscan.parsers.interfaces.ParserType;
import net.idscan.parsers.BarcodeParameters;

public class Main {

    // Sample TrackString encoded in base64
    final static String TrackStringBase64 ="QA0KHg0KQU5TSSA2MzYwNDAwODAwMDJETDAwNDEwMjU3WlUwMjk4MDAxMURMREFRMDAwDQpEQ1NWSVJFTExJDQpEREVODQpEQUNKVA0KRERGTg0KREFETk9ORQ0KRERHTg0KRENBRA0KRENCQg0KRENETk9ORQ0KREJEMDEyMzIwMjANCkRCQjAzMTMxOTczDQpEQkEwMzEzMjAyOA0KREJDMg0KREFVMDY0IGluDQpEQVlCUk8NCkRBRzEyMTgwIFMgMzAwIEUgIyAxMDg2DQpEQUlEUkFQRVINCkRBSlVUDQpEQUs4NDAyMDAwMDAgIA0KRENGNjExOTgyMzENCkRDR1VTQQ0KREFXMTM1DQpEQVpCUk8NCkRDSzE1MTQwNzE2N1VUVTBUTDAxDQpEREFGDQpEREIwNDE1MjAxNg0KWlVaVUENClpVQkkNCg0K";

    public static void main(String[] args) {

        String test_data = TrackStringBase64;

        var licPath = System.getProperty("user.dir");
        Path licenseFile = Paths.get(licPath + "/license.json");

        // Initialize instance of Parser
        var parser = new DLParser(licenseFile);
        
        var version = parser.GetParserVersion();
        
        System.out.println("Parser version: "+version);

        // By default: Parser in Strict Verification Mode
        // if you want to disable strict mode uncomment line below 
        //parser.DisableStrictMode();
        BarcodeParameters barcodeParam = new BarcodeParameters("GA_DLIC_2019_HORIZONTAL", 0,19,15,"USA");

        // Option 1.
        // Passing test_data to parser method.
        var result = parser.Parse(test_data, barcodeParam);

        // Option 2.
        // Passing test_data to parser method and get result as a json
        var json_result = parser.ParseToJson(test_data);

        // Do something with the result
        System.out.println();
        System.out.println(" ====  Validation Results:  ====");
        System.out.println("Full Name: "+result.IdentityCardPresenter.FullName);
        System.out.println("Status: "+result.Status);
        System.out.println("Document is valid: " + result.ValidationCode.IsValid);
        System.out.println("Barcode parameters are correct: " + result.ValidationCode.BarcodePDF417IsWell);
        System.out.println("The document is most likely suspicious: " + result.ValidationCode.IsWarning);

        System.out.println();
        // Print Errors if any
        for (ValidationError err : result.ValidationErrors) {
            System.out.println("error: " + err.ValidationCodeNumber + " - " + err.Description);
        }

        // Print Warnings if any
        for (ValidationError err : result.ValidationWarnings) {
            System.out.println("warning: " + err.ValidationCodeNumber + " - " + err.Description);
        }

        // Print PDF417Errors
        for (ValidationError err : result.ValidationBarcodePDF417Errors) {
            System.out.println("warning: " + err.ValidationCodeNumber + " - " + err.Description);
        }
    }
}
