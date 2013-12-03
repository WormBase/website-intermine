#!/bin/bash

# Dumps data from ACeDB in XML format.

cwd="`pwd`"
ace=/usr/local/wormbase/acedb/bin-4.9.52
dest="$1"

if [ $# -ne 1 ] ; then
  echo "A destination directory needs to be provided."
  echo ""
  echo "Example: ./website-intermine/scripts/dump_ace.sh directory_path"
  exit 1
fi

if [ -d website-intermine ] ; then
  cd website-intermine/acedb-dev/acedb
elif [-d acedb-dev ] ; then
  cd acedb-dev/acedb
else
  echo "This script must be executed either in website-intermine or one level above."
  exit 2
fi

./imdump.sh $dest
echo -e "query find Gene Live\nshow -x -f $dest/Gene.xml\nquery find Protein Corresponding_CDS\nshow -x -f $dest/Protein.xml\nquery find CDS Method=\"curated\"\nshow -x -f $dest/CDS.xml\nquery find Transcript (Gene)\nshow -x -f $dest/Transcript.xml\nKeySet-Read species.ace\nshow -x -f $dest/Species.xml" | /usr/local/wormbase/acedb/bin-4.9.52/tace "/usr/local/wormbase/acedb/wormbase"
chmod g+w $dest

cd "$cwd"

