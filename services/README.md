# Build DigitalTwin

Run install.bat to create the maven artifacts and build the docker image.

# Run

The current CSV file with additional heater information is already part of the image. 

If you mount the folder '/workspace/config/' into the container, any file with the ending .csv will be considered as input.

The CSV should have a header line and the following fields:

Company;CelNr;HzNr;HgNr;Building;Device_Performance;Device_Type

Example:

ExampleCompany;C1;1;1;Halle_18;33;Maxima_55i_Erdgas
...


The image is run in a [cron-jon](https://www.baeldung.com/ops/docker-cron-job)

Set the Environment Varialbe *CRON_JOB_EXPRESSION* to set up a different interval.
