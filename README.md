# Walking Skeleton

A minimal REST API created to test CI/CD automation and observability on a Oracle Cloud VPS.

## Tech Stach
- Java 25
- Spring Boot
- Spring Web
- Prometheus
- Grafana
- Docker
- Docker Compose
- Nginx
- Oracle Cloud VPS

## How to run
> You'll need `docker` and `docker compose` installed.

### A. Running locally
Clone this repo on your machine and run the following command on the project root  
`docker compose up --build`

The project will be available at [http://localhost/](http://localhost/).

### B. Running on a remote server
1. Ensure ports `80` and `443` are open on your `VPS` provider.  
  >If you use Oracles', you can do it on [OCI](https://cloud.oracle.com/). Make sure the ports are open on both `Security Lists` and `Network Security Groups`.
 
2. Ensure ports `80` and `443` are open on the `VPS` itself.
> - Connect to the `VPS` via `SSH`
>   - Run `sudo iptables -I INPUT 6 -p tcp --dport 80 -j ACCEPT`.
>   - Run `sudo iptables -I INPUT 6 -p tcp --dport 443 -j ACCEPT`.  
>   - Apply the changes to iptables `sudo netfilter-persistent reload`

3. Clone this repo on your VPS  
  `git clone https://github.com/lucas-marianno/walking-skeleton.git`

5. Start the docker container on the project root  
  `cd walking-skeleton/`  
  `docker compose up --build`  

The endpoints will be available at both `http://localhost/` **AND** at `http://your_vps_public_ip_address/`

>[!tip]
>If you own a domain, you can create a record on your registrar that points to the VPS' ip, and you'll have a fully set up website.

## API Documentation

### / Hello World endpoint
A shitty hello world endpoint.

endpoint: `GET` `/hello`  
returns: `200 OK` + body `hello stupid`  
params:  
  `name`: will replace `stupid` with given name  
  `delay`: will return after "n" seconds

### / Grafana
Provides the entrypoint to the grafana admin interface.

Grafana's provisioning is already set up. Data source is already connected to `Prometheus` and a dashboard is already created

endpoint: `GET` `/grafana` (on remote server) | `GET` `localhost:3000` (if running locally)

>[!tip]
>Grafana's default login and password is `admin`.

### / Prometheus
Provides raw metrics that will be read by grafana.

endpoint: `GET` `/actuator/prometheus` (on remote server) | `GET` `localhost:9090` (if running locally)
