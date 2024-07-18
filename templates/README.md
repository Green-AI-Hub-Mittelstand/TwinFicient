# Templates

Templates define dashboards, variables, and additional components of the InfluxDB UI. Use the *apply-templates.sh* script to apply the templates to your running InfluxDB instance. Run *export-templates.sh* to export your components and share them with others (they need to be marked with the twinficient label to be exported).

If there are any conflicts during application, run *remove-templates.sh* first. This will uninstall the deployed stack. You can then apply the templates again using the apply script.

## Requirements

- [Install Docker](../docker/README.md#install-docker)
- [Start the Docker stack](../docker/up.sh)
- Install the Influx CLI: [instructions](https://docs.influxdata.com/influxdb/cloud/reference/cli/influx/)
- Initialize the CLI with [this script](../init-influx.sh)
- The tasks run on measurement data, so do not forget to apply [the data backup](../backup/). Otherwise, the tasks will fail.

## Considerations

We used Grafana for dashboards and variable definitions because, in our opinion, Grafana is more powerful and visually appealing than the Influx dashboard components.

Additionally, the Influx tasks are not powerful enough for our needs, so we use a custom Java tool for aggregation.





