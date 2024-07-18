The scripts, that are part of this folder, offer functionality to extract and deploy aasx files. Assert, that you have the relevant java Java tools (with jar programm) installed.

# Development Process 

Use the [Eclipse AASX Package Explorer](https://github.com/eclipse-aaspe/package-explorer) to edit your aasx files.

Then invoke the *extract.sh* script to *unzip* all aasx files deployed to the [docker stack](../docker). 

If you commit files of this folder that are extracted previously, you will see exactly which files and textfile-content changed. This is not possible with binary files like aasx-files. It's also easier to solve merge-conflicts.

Run extract.sh to compress the file content again to an aasx file and deploy it to the [aasx-folder](../docker/data/aasx/) that is mounted to the basyxEnvironment component and thus deployed on the aas-services.




