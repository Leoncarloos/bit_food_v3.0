FROM ubuntu:latest
LABEL authors="Carlos Leon"

ENTRYPOINT ["top", "-b"]