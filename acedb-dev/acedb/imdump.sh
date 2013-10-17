#!/bin/bash

# expects models file

# Database directory: /usr/local/wormbase/acedb/wormbase
ACEDB_SUBDIR="wormbase";

if [ $# -ne 1 ]; then
    echo "Usage: $0 xmldumpdestinationdirectory"
    echo ""
    echo "Example: $0 /nfs/wormbase_ws239"
    exit 1
fi

dumpdir="$1"

if [ ! -e "models" ]; then
    echo Cannot find models file.
    exit 1
fi

if [ -z "$ACEDB" ]; then
    echo 'Did not specify AceDB dir in $ACEDB. Searching for tace...'
    ACEDB="/directory/not/set"
    for i in `find /usr -name tace` ; do
        ACEDB_BIN="`dirname $i`"
        ACEDB="`dirname $ACEDB_BIN`/$ACEDB_SUBDIR"
    done 2> /dev/null
    if [ ! -d "$ACEDB" ]; then
        echo "Did not find the executable 'tace'."
        exit 2
    fi
    echo "ACEDB set to: $ACEDB"
fi

if [ ! -e "$dumpdir" ]; then
mkdir $dumpdir 
fi

for model in `cat models`
do
    if [ ! -e "$dumpdir/$model.xml" ]
    then
        echo $model
        $ACEDB_BIN/tace "$ACEDB" <<EOF > /dev/null
wb

find ${model}
show -x -f "$dumpdir/$model.xml"
EOF
        echo ... done.
    fi
done
