# AAS file validation

This is a tool that validates aas. The validation uses the same java calls that are invoked then you deploy the files via the aas-environment docker container and use the aasx file upload.

The files are validated in a java test that is invoked by maven. Using the validate-aasx-files.sh script you can check that your file is valid before you starting the docker component.