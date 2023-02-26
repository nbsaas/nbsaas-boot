#!/bin/bash

echo "front服务  重启开始............."
SERVER_JAR_NAME="/disk/apps/saas/front-1.0.1.jar"

ID=$(ps -ef | grep "$SERVER_JAR_NAME" | grep -v "grep" | awk '{print $2}')
echo $ID
for id in $ID; do
  kill -9 $id
  echo "killed $id"
done

echo "重启服务中............."
nohup java   -Xms386m -Xmx386m -Xmn128m  -Xloggc:./logs/front.log -Dfile.encoding=utf-8 -jar  $SERVER_JAR_NAME >./logs/front.out 2>&1 &
echo "front服务 重启成功............."
