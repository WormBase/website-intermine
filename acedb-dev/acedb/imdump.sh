#!/bin/bash

# expects models file

dumpdir="/nfs/wormbase/ace_xml_dumps";

if [ ! -e "models" ]; then
    echo Cannot find models file.
    exit 1
fi

if [ -z "$ACEDB" ]; then
    ACEDB="/usr/local/wormbase/acedb/wormbase"
    echo 'Did not specify database dir in $ACEDB. Using ' $ACEDB
fi

if [ ! -e "$dumpdir" ]; then
mkdir $dumpdir 
fi

for model in `cat models`
do
    if [ ! -e "$dumpdir/$model.xml" ]
    then
        echo $model
        tace "$ACEDB" <<EOF > /dev/null
wb

find ${model}
show -x -f "$dumpdir/$model.xml"
EOF
        echo ... done.
    fi
done
