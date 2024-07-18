# TwinFicient docker stack

## Install docker

For Windows:

Run Docker on WSL2:

Enable WSL2: <https://pureinfotech.com/install-windows-subsystem-linux-2-windows-10/>

Install Rancher Desktop: <https://rancherdesktop.io/>

- on startup use dockerd and disable kubernetes
- (open File/Preferences/WSL: Select the installed WSL installation)
- installation takes a while -> after that open command shell -> type: docker run hello-world -> download and execution should be successful
- (WSL distro and) Rancher Desktop need to be started to use the docker client

Other Platforms:

<https://docs.docker.com/engine/install/>

If something went wrong, try to install Ubuntu from Windows store. It could be that you need a kernel update. If this is the case you will see a URL where you find the download link.
If Rancher fails to be installed, try to set the default WSL version with "wsl --set-default-version 2"

## Configuration

Edit the .env file to configure variables like *EXTERNAL_HOSTNAME*.

*EXTERNAL_HOSTNAME* is the DNS name that is used to access the services via your web browser.

If you do not have a DNS just update the etc/hosts file or use 'localhost' as setting.

The chrome browser can resolve localhost domains to the current PC (127.0.0.1).

## Run services

Run ./up.sh to start the services

Open http://localhost ( is *EXTERNAL_HOSTNAME* is set to localhost ) to access the services

## Tear down services

Run ./down.sh

## Restart InfluxDB

If you run to complex/big queries and the influx browser view hangs, restart the service using the *restart-influxdb.sh* script.
