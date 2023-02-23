# File System Access Docker

Test project to test IO access from within a docker container.

## About

Docker containers are immutable. This project is to test whether read/write access at runtime is
still possible. (It seems so.)

## Usage

This section describes how to run the program in standalone and from a docker container

### Standalone

Execute this command to test the java program without docker:

```bash
mvn  clean package exec:java
```

### Container

Execute these commands to test the program from a container:

```bash
# Remove container (if already created)
docker rm fs-io

# Remove image (if already created)
docker image rm docker-fs:commonsio

# Build image
docker build -t "docker-fs:commonsio" . -f Dockerfile

# Run container to test file system access
docker run --name=fs-io docker-fs:commonsio
```

## Contact / Pull Requests

* Author: Maximilian Schiedermeier
* Github: [m5c](https://github.com/m5c)
* Webpage: https://www.cs.mcgill.ca/~mschie3
* License: [MIT](https://opensource.org/licenses/MIT)
