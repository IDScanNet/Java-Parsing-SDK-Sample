# ID Parser Library for Java
This project demonstrates how to use **ID Parser library for Java** from [IDScan.net](https://idscan.net/).
This SDK requires a license.json file from IDScan.net. Please contact sales@idscan.net if needing a license.
## Installation

### Eclipse

1. Add **net.idscan.parsers.jar** to the project as external **jar** file:
    + Open **project properties**(Alt + Enter) → **Java Build Path** → **libraries** tab.
    + Add JARs...
    + Select **net.idscan.parsers.jar** and press OK.

2. Setup **Dynamic Link Library**. **net.idscan.parsers.jar** depends on a native library. You need to setup **java.library.path** variable so that Java VM can find the appropriate library.
    + Open **project properties**(Alt + Enter) → **Java Build Path** → **libraries** tab.
    + Expand **dlparserlib.jar**, select **Native Library Location** and press **Edit...**
    + Select **PROJECT_NAME/libs** folder and press **Ok**.

## Usage

1. Create ```DLParser``` object.
```
var licenseFilePath = "<path_to_license_file>";
var parser = new DLParser(licenseFilePath);
```

2. Parse the data. For parsing data you need to call ```parse(String)``` method.
```
try {
    var result = parser.Parse(test_data);
} catch(Exception e) {
    // TODO: handle the error.
}
```

You can find a complete example of using the library in the ```Main.java```.
