package connection;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSClient {
	private static FileSystem fs =null;
	
	public static synchronized FileSystem getFileSystem() throws IOException{
		if((fs == null)||(!checkfs())){
			Configuration conf = new Configuration();
			conf.addResource(new Path("conf/core-site.xml"));
			conf.addResource(new Path("conf/hdfs-site.xml"));
			conf.addResource(new Path("conf/mapreduce-site.xml"));
			conf.addResource(new Path("conf/hbase-site.xml"));
			conf.addResource(new Path("conf/yarn-site.xml"));
			fs = FileSystem.get(conf);
		}
		return fs;
	}
	
	public static synchronized boolean checkfs(){
			try{
				fs.exists(new Path("/"));
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}
	
	

}