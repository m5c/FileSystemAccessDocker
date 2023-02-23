# File System Access Docker

Test project to test IO access from within a docker container.

## Usage

To test the java program without docker:

```bash
mvn  clean package exec:java
```

To test the program from a container:

```bash
docker system prune -a
docker build -t "docker-fs:commonsio" . -f Dockerfile
docker run --name=fs-io docker-fs:commonsio
```