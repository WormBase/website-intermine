#!/bin/bash

# Gets, installs, and sets up a Tomcat installation.
#
# Parameter: Tomcat version number.

cwd="`pwd`"
version="$1"

if [ $# -ne 1 ] ; then
  echo "One parameter needed: Tomcat version number"
  echo ""
  echo "Example: ./website-intermine/scripts/install_tomcat.sh 7.0.74"
  echo ""
  echo "Available Tomcat versions:"
  echo ""
  curl -s http://apache.mirror.nexicom.net/tomcat/tomcat-7/ | grep -o -E '"v[0-9]+\.[0-9]+\.[0-9]+' | tr -d 'v"'
  exit 1
fi

wget http://apache.mirror.nexicom.net/tomcat/tomcat-7/v$version/bin/apache-tomcat-$version.tar.gz
tar xzf apache-tomcat-$version.tar.gz
cd apache-tomcat-$version
PASSWORD=wormses ; echo -e "<?xml version='1.0' encoding='utf-8'?>\n<tomcat-users>\n   <role rolename=\"manager-gui\"/>\n   <role rolename=\"manager-script\"/>\n   <user username=\"manager\" password=\"$PASSWORD\" roles=\"manager-gui,manager-script\"/>\n</tomcat-users>\n" > conf/tomcat-users.xml
sed 's/<Connector/<Connector URIEncoding="UTF-8"/' conf/server.xml > server.xml.tmp
mv server.xml.tmp conf/server.xml
sed 's/^exec/export JAVA_OPTS="$JAVA_OPTS -Dorg.apache.el.parser.SKIP_IDENTIFIER_CHECK=true"\nexec/' bin/startup.sh > startup.tmp
mv startup.tmp bin/startup.sh
chmod +x bin/startup.sh

cd "$cwd"

