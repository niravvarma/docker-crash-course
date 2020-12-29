# Docker Crash Course

1. This project is replica of the original [project](https://github.com/in28minutes/docker-crash-course) with some little changes.
2. This project is awesome and provides a good info on learning docker, dockerizing microservices and monitoring dockerized microservices.
3. Further details of the projects can be found on the original project by in28minutes.

## Listing some of the docker commands from the course

### Abbreviation used
- Account Name: acc
- Image Name: img
- Repository with tag: repo == acc/img
- Tag Name: tag

### Common commands
1. Check what docker is doing: ``docker events``
2. Check docker container usage: ``docker top <container-id>``
3. Check docker statistics: ``docker stats``
4. Check docker system stats: ``docker system df``
5. Check docker network: ``docker network ls``
6. Check which container is running on a particular network type for e.g. bridge network: ``docker inspect bridge``
7. Create your own network: ``docker network create <your-network-name>``

### Container commands

1. Run docker: ``docker run <repo:tag>``
2. Run docker detached i.e. even with Ctrl+C, image container keeps on running: ``docker run -d <repo:tag>``
3. Run docker detached with interactive shell (-i == interative and -t = tty): ``docker container run -dit <repo:tag>``
4. If docker already running in interactive shell, one can run shell commands like following: ``docker container exec <container-name> <some-shell-command>``
5. Copying files to running container: ``docker container cp <filename> <container-name>:<path>`` OR ``docker container cp <filename> <container-id>:<path>``
6. Create an image from the running container: ``docker container commit <container-name> <repo-name>:<your tag-name>``
7. Create an image from the running container and command: ``docker container commit --change='CMD ["java","-jar","/tmp/hello-world-rest-api.jar"]' <container-name> <repo-name>:<your tag-name>``
8. Create an image from dockerfile and file to be copied: ``docker build -t <repo-name>:<your tag-name>``
9. Run docker with port exposed: ``docker run -p <out-port>:<container-app-port> -d <repo:tag>`` OR ``docker container run -p <out-port>:<container-app-port> -d <repo:tag>``
10. Run docker with allocated CPU quota (100000 = 100%) and memory (512m / 0.5g / 1g): ``docker container run -p <out-port>:<container-app-port> -d -m 0.5g --cpu-qouta 5000 <repo:tag>``
11. Running and stopped containers: ``docker container ls -a``
12. Checking running container logs after you get container id from above command: ``docker logs <container-id>``
13. Logs with tailing: ``docker logs -f <container-id>``
14. Stop running container (SIGTERM - gracefully shutdowns container): ``docker container stop <container-id>``
15. Kill running container (SIGKILL - immediately kills the process) (DON'T USE UNTIL REQUIRED): ``docker container kill <container-id>``
16. Pause / Unpause running container (stops container in specific state): ``docker container pause <container-id>`` OR ``docker container unpause <container-id>``
17. Inspect: ``docker container inspect <container-id>``
18. Remove stopped containers: ``docker container prune``
19. Restart policy (if you stop docker daemon i.e. docker itself and restart, then container will start automatically if container was ran with --restart=always and if prune command was not ran. In order to stop, run container stop and then prune command. Use for e.g. db run on restarting docker): ``docker container run --restart=always -d -p <out-port>:<container-app-port> <repo:tag>``
20. Restart container: ``docker container restart <container-id>``

### Image commands
1. Check downloaded images: ``docker images``
2. Tag docker images: ``docker tag <repo:tag> <repo:YOUR-TAG-NAME>``
3. Download only image: ``docker pull <image-name>``
4. Search for any image: ``docker search <image-name>``
5. Check image history: ``docker image history <img-id> / docker history <repo>``
6. Image inspect: ``docker image inspect <img-id>``
7. Remove image from locale: ``docker image remove <img-id>``
    
### Compose commands
1. In detach mode: ``docker-compose up -d``
2. To stop: ``docker-compose down``
3. Check events: ``docker-compose events``
4. Config and validate any errors: ``docker-compose config``
5. Images used: ``docker-compose images``
6. List of containers: ``docker-compose ps``
7. Pause / unpause: ``docker-compose pause`` / ``docker-compose unpause``
8. Stop / Kill: ``docker-compose stop`` / ``docker-compose kill``
9. Remove all containers: ``docker-compose rm``
10. For all services, build all the images: ``docker-compose build``
11. Check running processes: ``docker-compose top``