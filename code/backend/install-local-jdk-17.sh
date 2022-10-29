#!/bin/bash
set -e

DIR="./db"
JAVADIR="jdk17"

if [ ! -d "$DIR" ]; then
  echo "${DIR} does not exist, the installation has exited ..."
  exit 1
fi

if [ -d "$DIR/$JAVADIR" ]; then
  echo "${DIR}/${JAVADIR} already exists, the installation has exited ..."
  exit 1
fi

echo "Installing JDK-17 in ${DIR}/${JAVADIR} ..."
cd ${DIR}


# download temurin 17
JDK_URL="http://edufs.edu.htl-leonding.ac.at/~t.stuetz/download/nvs/jdk/OpenJDK17U-jdk_x64_linux_hotspot_17.0.1_12.tar.gz"
#JDK_URL="https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.1%2B12/OpenJDK17U-jdk_x64_linux_hotspot_17.0.1_12.tar.gz"

# download jdk
curl -L -O ${JDK_URL}
tar xzvf OpenJDK17U-jdk_x64_linux_hotspot_17.0.1_12.tar.gz
mv jdk-17.0.1+12 ${JAVADIR}
rm OpenJDK17U-jdk_x64_linux_hotspot_17.0.1_12.tar.gz
echo "Installation of jkd17 completed ..."
echo "to use this JDK invoke 'source ./set-local-env.sh'"