package connection;

import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @author dell
 *注意避免同一个jvm里面同时开多个线程调用filesystem(用filesystem.get方法)
 *可设置成单例的模式。然后互相传递着用这个对象。
 */
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
