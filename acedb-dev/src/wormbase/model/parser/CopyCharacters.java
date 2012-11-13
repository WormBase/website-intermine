package wormbase.model.parser;

import java.io.*;
import java.util.*;

public class CopyCharacters {
    public static void main(String[] args) {
    	String infile = "/home/jwong/git/website-intermine/acedb-dev/acedb/datafiles/gene1.jace";
    	String outfile = "DELETE.txt";
    	
    	CopyCharacters obj = new CopyCharacters();
    	try {
			obj.read2list(infile);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	System.out.println("fin.");
    }

    public void copyFile(String infile, String outfile) throws IOException {
    	
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(infile);
            outputStream = new FileWriter(outfile);

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }		
    	
    }
    
    public byte[] read2array(String file) throws Exception {
        InputStream in = null;
        byte[] out = new byte[0];
        try{
           in = new BufferedInputStream(new FileInputStream(file));
           // the length of a buffer can vary
           int bufLen = 10000; //20000*1024;
           byte[] buf = new byte[bufLen];
           byte[] tmp = null;
           int len    = 0;
           while((len = in.read(buf,0,bufLen)) != -1){
              // extend array
              tmp = new byte[out.length + len];
              // copy data
              System.arraycopy(out,0,tmp,0,out.length);
              System.arraycopy(buf,0,tmp,out.length,len);
              out = tmp;
              tmp = null;          
           }
        }finally{
           // always close the stream
           if (in != null) try{ in.close();}catch (Exception e){}
        }
        return out;
     }
    
    /**
     *  Reads a file storing intermediate data into a list. Fast method.
     *  @param file the file to be read
     *  @return a file data
     */
     public byte[] read2list(String file) throws Exception {
        InputStream in = null;
        byte[] buf             = null; // output buffer
        int    bufLen          = 20000; //20000*1024;
        try{
           in = new BufferedInputStream(new FileInputStream(file));
           buf = new byte[bufLen];
           byte[] tmp = null;
           int len    = 0;
           List data  = new ArrayList(24); // keeps peaces of data
           while((len = in.read(buf,0,bufLen)) != -1){
              tmp = new byte[len];
              System.arraycopy(buf,0,tmp,0,len); // still need to do copy
              data.add(tmp);
           }
           /*
              This part os optional. This method could return aList data
              for further processing, etc.
           */
           len = 0;
           if (data.size() == 1) return (byte[]) data.get(0);
           for (int i=0;i<data.size();i++) len += ((byte[]) data.get(i)).length;
           buf = new byte[len]; // final output buffer
           len = 0;
           for (int i=0;i<data.size();i++){ // fill with data
             tmp = (byte[]) data.get(i);
              System.arraycopy(tmp,0,buf,len,tmp.length);
              len += tmp.length;
           }
        }finally{
           if (in != null) try{ in.close();}catch (Exception e){}
        }
        return buf;
     }
     
}
