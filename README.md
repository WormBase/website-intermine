##### wormmine  

file info:  
* ( acedb, perllib, scripts, bin ): 	reference files  
* acedb-dev: 				eclipse project  
* software: 				configured for InterMine

# Create Intermine dump files and sync to the new development host

    > cd website-intermine
    > sudo mkdir /mnt/ephemeral0/intermine-builds/WSXXX 
    > sudo chown tharris:wormbase /mnt/ephemeral0/intermine-builds/WSXXX
    > ./scripts/dump_ace.sh WSXXX
    > scp -r WSXXX im-WSXXX.wormbase.org:/media/ephemeral0/intermine-builds/.

