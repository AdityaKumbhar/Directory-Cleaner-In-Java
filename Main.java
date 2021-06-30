/*
import java.lang.*;

//for collection frame work
import java.util.*;

//for directoy traversal
import java.io.*;

//for file reading
import java.io.FileInputStream;

// For checksum
import java.security.MessageDigest;

class Main{
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please Enter The Directory Name");
		String dir = br.readLine();

		Cleaner cobj = new Cleaner(dir);

		//To remove the empty files
		cobj.CleanDirectoryEmptyFile();

		//To remove the duplicate file
		cobj.CleanDirectoryDuplicateFile();

	}
}

class Cleaner{
	public File fdir = null;

	public cleaner(String name){
		// check the existance of directory
		fdir = new File(name);
		if(!dir.exists()){
			System.out.println("Invalid Directory Name");
			System.exit(0);
		}
	}

	public void CleanDirectoryEmptyFile(){
		File filelist[] = fdir.listFiles();
		int EmptyFile = 0;

		for(File file : filelist)
		{
			if(file.length() == 0){
				System.out.println("Empty File Name : "+file.getName());

				if(!file.delete()){
					System.out.println("Unable To Delete");
				}
				else{
					EmptyFile++;
				}
			}
		}
		System.out.println("Total Empty Files Deleted " :+EmptyFile);
	}

	public void CleanDirectoryDuplicateFile() throws Exception
	{
		//List all file from directory
		File filelist[] = fdir.listFiles();

		//Counter to count number of duplicate files
		int DupFile = 0;

		//Bucket To read the data
		byte bytearr[] = new byte[1024];

		//Create The Linked List of a link to Stored the check sum
		LinkedList<String> lobj = new LinkedList<String>();

		//Counter To Read The data from file

		int Rcount = 0;

		try{
			MessageDigest digest = MessageDigest.getInstance("MD5");

			if(digest == null){
				System.out.println("Unable To Open MD5");
				System.exit(0);
			}

			for(File file : filelist){

				//Object To read data from the file
				FileInputStream fis = new FileInputStream(file);

				if(file.length()!= 0){
					while((Rcount = fis.read(bytearr))!= -1){
						digest.update(bytearr,0,Rcount);
					}
				}

				//to get hash byte from check sume
				byte bytes[] = digest.digest();

				//StringBuffer to create editable string
				StringBuilder sb = new StringBuilder();

				for(int i = 0; i < byte.length; i++){
					//Add Each byte from decimal to hexa decimal in the stringbuffer
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
				}
				System.out.println("File name : " + file.getName()+"Checksume : "+sb);

				if(lobj.contains(sb.toString())){
					if(!file.delete()){
						System.out.println("Unable To Delete A File : "+file.getName());
					}
					else{
						System.out.println("File Gets Deleted : "+file.getName());
						DupFile++;
					}
				}
				else{
					lobj.add(sb.toString());
				}

				fis.close();
			}
		}
		catch(Exception obj){
			System.out.println("Exception Occured :"+obj);
		}
		finally{

		}
		System.out.println("Total Duplicate File Deleted  : " +DupFile);
	}
}
*/


import java.lang.*;

// For collection framework
import java.util.*;

// Fore directory traversal
import java.io.*;

// For file reading
import java.io.FileInputStream;

// For checksum
import java.security.MessageDigest;

class Main
{
	public static void main(String arg[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new
		InputStreamReader(System.in));
		System.out.println("Please enter directory name");
		String dir = br.readLine();
		Cleaner cobj = new Cleaner(dir);
		// To remove empty files
		cobj.CleanDirectoryEmptyFile();
		// To remove duplicate files
		cobj.CleanDirectoryDuplicateFile();
	}
}

class Cleaner
{
	public File fdir = null;
	public Cleaner(String name)
	{
		// Check the existance of directory
		fdir = new File(name);
		if(!fdir.exists())

		{
			System.out.println("Invalid Directory name");
			System.exit(0);
		}
	}

	public void CleanDirectoryEmptyFile()
	{
		File filelist[] = fdir.listFiles();
		int EmptyFile = 0;
		for(File file : filelist)
		{
			if(file.length() == 0)
			{
				System.out.println("Empty file name :"+file.getName());
				if(!file.delete())
				{
					System.out.println("Unable to delete");
				}
				else
				{
					EmptyFile++;
				}
			}
		}
		System.out.println("Total empty files deleted : "+ EmptyFile);
	}	

	public void CleanDirectoryDuplicateFile() throws Exception
	{
		// List all files from directory
		File filelist[] = fdir.listFiles();
		// Counter to count number of duplicate files
		int DupFile = 0;
		// Bucket to read the data
		byte bytearr[] = new byte[1024];
		// Create linkedlist of strings to store the checksum
		LinkedList<String> lobj = new LinkedList<String>();
		// Counter to read the data from file

		int Rcount = 0;
		try
		{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			if(digest == null)
			{
				System.out.println("Unable to get the MD5");
				System.exit(0);
			}
			
			for(File file : filelist)
			{
				// Object to read the data from file
				FileInputStream fis = new FileInputStream(file);
				if(file.length() != 0)
				{	
					while((Rcount = fis.read(bytearr)) != -1)
					{
						digest.update(bytearr,0,Rcount);
					}
				}
				// to get the hash bytes of cheksum
				byte bytes[] = digest.digest();
				// Stringbuffer to create editable string
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < bytes.length; i++)
				{
					// Add each byte from decimal to hexadecimal in the stringbuffer
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}

				System.out.println("File name : " + file.getName()+"Checksum : "+sb);

				if(lobj.contains(sb.toString()))
				{
					if(!file.delete())
					{
						System.out.println("Unable to delete file :"+file.getName());
					}
					else
					{
						System.out.println("File gets deleted :"+file.getName());
						DupFile++;
					}
				}
				else
				{
					lobj.add(sb.toString());
				}
				fis.close();
			}
		}

		catch(Exception obj)
		{
			System.out.println("Exception occured : "+obj);
		}
		finally
		{
			//finally block
		}
			System.out.println("Total duplicate files deleted : "+ DupFile);
	}
}
