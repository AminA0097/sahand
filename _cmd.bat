@echo off
setlocal enabledelayedexpansion

for /f "tokens=1,2" %%a in ('docker ps -a --format "{{.ID}} {{.Image}}"') do (
    set "CONTAINER_ID=%%a"
    set "IMAGE_NAME=%%b"
    echo !IMAGE_NAME! | findstr /i "openjdk postgres minio" >nul
    if errorlevel 1 (
        docker rm -f !CONTAINER_ID!
    )
)

echo *** Stopping sahandApp container (ignore errors if not running) ***
docker-compose stop sahandapp

echo *** Removing sahandApp container (ignore errors if not exist) ***
docker-compose rm -f sahandapp

echo *** Building sahandApp image ***
docker-compose build sahandapp

echo *** Starting sahandApp container ***
docker-compose up -d sahandapp

echo *** removing none tag ***
docker image prune -f

echo *** All done! ***
pause
