package com.pradeep.test.hashmap;

import java.io.IOException;
import com.google.common.collect.HashBasedTable;

public class listdata 
{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashBasedTable<String,String,String> abcd = HashBasedTable.create();
		 abcd=guavatable.datatable("Sheet 1");
		 System.out.println (abcd.get("TC_4", "BB"));
	}
}
