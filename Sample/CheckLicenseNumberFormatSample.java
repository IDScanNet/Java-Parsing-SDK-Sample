package com.idscan;

import java.nio.file.Path;
import java.nio.file.Paths;

import net.idscan.parsers.DLParser;
import net.idscan.parsers.interfaces.CheckLicenseNumberFormatResult;

public class Main {

    public static void main(String[] args) {

        var licPath = System.getProperty("user.dir");
        Path licenseFile = Paths.get(licPath + "/license.json");

        // Initialize instance of Parser
    	var parser = new DLParser(licenseFile);

        String IssuedBy = "OH";
        String LicenseNumber = "A1234567";
        String CountryCode = "USA";

        var licenseCheckResult = parser.CheckLicenseNumberFormat(IssuedBy, LicenseNumber, CountryCode);

        System.out.println(" ====  License Number Format Check  ====");
        System.out.println("Status: "+licenseCheckResult.Status);
        System.out.println("IsValid: "+licenseCheckResult.IsValid);
        System.out.println("Code: " +licenseCheckResult.Code);
        System.out.println("Message: " + licenseCheckResult.Message);
    }
}
