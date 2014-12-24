#!/bin/bash

# Dump data from ACeDB in XML format.

CWD="`pwd`"
VERSION="$1"

if [ ! $VERSION ] ; then
  echo ""
  echo "Generate XML dumps to begin a build of intermine."
  echo "You must provide the WSXXX version you wish to build."
  echo ""
  echo "Example: ./scripts/dump_ace.sh WS246"
  exit 1
fi

ACEDB_BASE=/usr/local/wormbase/acedb
ACEDB_BIN=${ACEDB_BASE}/bin
ACEDB_DATA=${ACEDB_BASE}/wormbase_${VERSION}

# Assuming that we are on AWS...
DESTINATION=/mnt/ephemeral0/intermine-builds/$VERSION

# Create the destination directory
if [ ! -e "$DESTINATION" ]; then
    mkdir -p $DESTINATION
fi

# Cd to the acedb-dev directory in order to find our models.
if [ -d acedb-dev ] ; then
    cd acedb-dev/acedb
else
  echo "This script should be executed from the website-intermine/ root level."
  exit 2
fi


# Do a straight dump of specific classes based on the models file
if [ ! -e "models" ]; then
    echo Cannot find models file.
    exit 1
fi

for model in `cat models`
do
    if [ ! -e "$DESTINATION/$model.xml" ]
    then
        echo $model
        $ACEDB_BIN/tace "$ACEDB_DATA" <<EOF > /dev/null
wb

find ${model}
show -x -f "$DESTINATION/$model.xml"
EOF
        echo ... done.
    fi
done


# Some classes require custom queries to simplify the resulting XML.
# The invocation below is the same as running commmands in tace
# from the command line:
#
# acedb> query find Gene Live
# acedb> show -x -f <ACE XML DUMP>/Gene.xml
# etc...

echo -e "query find Gene Live\nshow -x -f $DESTINATION/Gene.xml\nquery find Protein Corresponding_CDS\nshow -x -f $DESTINATION/Protein.xml\nquery find CDS Method=\"curated\"\nshow -x -f $DESTINATION/CDS.xml\nquery find Transcript (Gene)\nshow -x -f $DESTINATION/Transcript.xml\nKeySet-Read species.ace\nshow -x -f $DESTINATION/Species.xml" | ${ACEDB_BIN}/tace ${ACEDB_DATA}
chmod g+w $DESTINATION

cd "$CWD"

