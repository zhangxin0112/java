package connection;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class HbaseClient {
	private	static Configuration configuration ;
	public HbaseClient(){
		if(configuration == null){
			configuration = HBaseConfiguration.create();
		    configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
		    configuration.set("hbase.zookeeper.quorum", "192.168.0.11,192.168.0.13,192.168.0.14"); 
		    configuration.set("hbase.master", "192.168.0.11"); 
		}
	}
	public static void main(String[] args) {
		HbaseClient hbaseClient =  new HbaseClient();
		hbaseClient.createTable("test_zx");
	}
	public void createTable(String tableName){
		
		 System.out.println("start create table ......"); 
	        try { 
	            HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration); 
	            if (hBaseAdmin.tableExists(tableName)) {// 如果存在要创建的表，那么先删除，再创建 
	                hBaseAdmin.disableTable(tableName); 
	                hBaseAdmin.deleteTable(tableName); 
	                System.out.println(tableName + " 已经存在这个表了！！！！那就先离线表。然后删除表。。"); 
	            } 
	            
	            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName); 
	            tableDescriptor.addFamily(new HColumnDescriptor("column1")); 
	            tableDescriptor.addFamily(new HColumnDescriptor("column2")); 
	            tableDescriptor.addFamily(new HColumnDescriptor("column3")); 
	            hBaseAdmin.createTable(tableDescriptor); 
	        } catch (MasterNotRunningException e) { 
	            e.printStackTrace(); 
	        } catch (ZooKeeperConnectionException e) { 
	            e.printStackTrace(); 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        System.out.println("end create table ......"); 
	}
}
