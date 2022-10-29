set -e
echo download scripts for quarkus project ...
echo "for jdk 17 run 'download-derbydb-and-jdk.sh java'"
URL=http://edufs.edu.htl-leonding.ac.at/~t.stuetz/download/nvs/scripts/
curl -O ${URL}datasource.txt
curl -O ${URL}derbydb-create.sh
curl -O ${URL}derbydb-start.sh
chmod +x derby*
curl -O ${URL}application.properties
#curl -O ${URL}add-assertj-to-pom.sh
#chmod +x ./add-assertj-to-pom.sh

# when parameter 'java' download jdk
if [ "$1" = "java" ]
  then
    curl -O ${URL}install-local-jdk-17.sh
    curl -O ${URL}set-local-env.sh
    chmod +x install-local-jdk-17.sh
    chmod +x set-local-env.sh
    echo "JDK downloaded"
    echo "run script to download jdk './install-local-jdk-17.sh'"
    #echo "to use this JDK invoke 'source ./set-local-env.sh'"
fi

# add db/ to .gitignore, when db does not exist
if [ ! -d "db" ]; then
  echo "db/" >> .gitignore
fi
./derbydb-create.sh
