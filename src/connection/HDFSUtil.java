package connection;

import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSUtil {
	private static FileSystem filesystem = null;
	
	/**
	 * HDFSUtil构造器
	 */
	public HDFSUtil(){
		if(filesystem == null){
			try {
				filesystem = HDFSClient.getFileSystem();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void getAllFile(){
		
	}
	public void deleteDir(){
		
	}
	public void mkdir(String name){
		 try {
			if(filesystem .exists(new Path(name))){
				 throw new RuntimeException("文件已经存在");
			 }else{
				 filesystem.mkdirs(new Path(name));
			 }
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rename(){
		
	}
	public void move(){
		
	}	

	public static void main(String[] args) {
		HDFSUtil hdfsutil = new HDFSUtil();
		hdfsutil.mkdir("user/zx/bbb.nb");
		hdfsutil.deleteDir();
		
		System.out.println();
	}
	
}
