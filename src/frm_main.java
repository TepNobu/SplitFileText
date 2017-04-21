import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;


import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class frm_main extends JFrame {

	private JPanel contentPane;
	private JTextField log;
	private JTextField txtFileName;
	private JTextField txtAmountSplit;
	private JTextField txtOutputPath;
	private JTextField txtTotalLines;
	private JTextField txtTotalFileGen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_main frame = new frm_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_main() {
		setTitle("WL-SplitFileSMS v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //Create a file chooser
		JFileChooser fc = new JFileChooser("C:/");

		setBounds(100, 100, 584, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 13, 542, 227);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Choose File");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(390, 25, 99, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int returnVal = fc.showOpenDialog(frm_main.this);
				// int returnVal = fc.
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	               // File file = fc.getSelectedFile();
	                //log.setText(file.getName());
	            	
	            	log.setText(fc.getSelectedFile().getAbsolutePath());
	        
	            } else {
	            	log.setText(null);
	               // log.append("Open command cancelled by user." + newline);
	            }
	            log.setCaretPosition(log.getDocument().getLength());

			}
		});
		panel.setLayout(null);
		
		JLabel lblSos = new JLabel("Input Path:");
		lblSos.setBounds(12, 4, 75, 16);
		panel.add(lblSos);
		
		JLabel lblNewLabel = new JLabel("New File Name:");
		lblNewLabel.setBounds(44, 102, 99, 16);
		panel.add(lblNewLabel);
		
		log = new JTextField();
		log.setBounds(22, 26, 356, 22);
		panel.add(log);
		log.setColumns(30);
		panel.add(btnNewButton);
		
		txtFileName = new JTextField();
		txtFileName.setBounds(145, 99, 233, 22);
		panel.add(txtFileName);
		txtFileName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("No. of lines to be split:");
		lblNewLabel_1.setBounds(12, 61, 131, 16);
		panel.add(lblNewLabel_1);
		
		txtAmountSplit = new JTextField();
		txtAmountSplit.setText("1000");
		txtAmountSplit.setBounds(145, 58, 233, 22);
		panel.add(txtAmountSplit);
		txtAmountSplit.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Output Path:");
		lblNewLabel_2.setBounds(68, 137, 75, 16);
		panel.add(lblNewLabel_2);
		
		txtOutputPath = new JTextField();
		txtOutputPath.setBounds(145, 134, 233, 22);
		panel.add(txtOutputPath);
		txtOutputPath.setColumns(10);
		
		JLabel lblLinesInThe = new JLabel("Total Lines in the file:");
		lblLinesInThe.setBounds(12, 166, 131, 16);
		panel.add(lblLinesInThe);
		
		JLabel lblNewLabel_3 = new JLabel("Total files  generated :");
		lblNewLabel_3.setBounds(12, 198, 131, 16);
		panel.add(lblNewLabel_3);
		
		txtTotalLines = new JTextField();
		txtTotalLines.setBounds(145, 163, 116, 22);
		panel.add(txtTotalLines);
		txtTotalLines.setColumns(10);
		
		txtTotalFileGen = new JTextField();
		txtTotalFileGen.setBounds(145, 195, 116, 22);
		panel.add(txtTotalFileGen);
		txtTotalFileGen.setColumns(10);
		
		JLabel lblLine = new JLabel("Lines");
		lblLine.setBounds(273, 198, 56, 16);
		panel.add(lblLine);
		
		JLabel lblFile = new JLabel("Files");
		lblFile.setBounds(273, 169, 56, 16);
		panel.add(lblFile);
		
		JButton btnSplit = new JButton("Split");
		btnSplit.setBackground(Color.GREEN);
		btnSplit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  try{  
                	  // Reading file and getting no. of files to be generated  
					//custom title, warning icon
					 if( log.getText().length()<=0){
						 JOptionPane.showMessageDialog(null,
							      "กรุณาเลือกFileที่ต้องการ",
							      "Inane warning",
							      JOptionPane.WARNING_MESSAGE);
						 return;
					 
					 }
					 if(  txtAmountSplit.getText().length()<=0){
					 
						 JOptionPane.showMessageDialog(null,
							      "กรุณาระบุLine ที่ต้องการตัด",
							      "Inane warning",
							      JOptionPane.WARNING_MESSAGE);
						 return;
					 
					 }
					 if(  txtFileName.getText().length()<=0){
						 
						 JOptionPane.showMessageDialog(null,
							      "กรุณาตั้งชื่อFileที่ต้องการ",
							      "Inane warning",
							      JOptionPane.WARNING_MESSAGE);
						 return;
					 
					 }
				if(  txtOutputPath.getText().length()<=0){
						 
						 JOptionPane.showMessageDialog(null,
							      "กรุณาเลือกสถานที่เก็บFile",
							      "Inane warning",
							      JOptionPane.WARNING_MESSAGE);
						 return;
					 
					 }
				
				if (!txtAmountSplit.getText().matches("[0-9]+")) {
					 JOptionPane.showMessageDialog(null,
						      "กรุณากรอกเฉพาะตัวเลขเท่านั้น !",
						      "Inane warning",
						      JOptionPane.WARNING_MESSAGE);
					 return;
				    //System.out.println("Invalid number");
				}

				
					//  System.out.println(log.getText().replaceAll("'\'", "'//'"));
					  String inputfile = log.getText(); 
                	//  String inputfile = "C://SMS//"+log.getText(); //  Source File Name.  
                	//  double nol = 1000.0; //  No. of lines to be split and saved in each output file.  
                	  double nol =  Double.parseDouble(txtAmountSplit.getText());
                	  //File file = new File(inputfile);  
                	  File  file = new File(inputfile);  
                	  Scanner scanner = new Scanner(file);  
                	  int count = 0;  
                	  while (scanner.hasNextLine())   
                	  {  
                	   scanner.nextLine();  
                	   count++;  
                	  }  
                	  System.out.println("Lines in the file: " + count);     // Displays no. of lines in the input file.  
                	  txtTotalLines.setText(Integer.toString(count));
                	  double temp = (count/nol);  
                	  int temp1=(int)temp;  
                	  int nof=0;  
                	  if(temp1==temp)  
                	  {  
                	   nof=temp1;  
                	  }  
                	  else  
                	  {  
                	   nof=temp1+1;  
                	  }  
                	  System.out.println("No. of files to be generated :"+nof); // Displays no. of files to be generated.  
                	  txtTotalFileGen.setText(Integer.toString(nof));
                	  //---------------------------------------------------------------------------------------------------------  

                	  // Actual splitting of file into smaller files  

                	  FileInputStream fstream = new FileInputStream(inputfile); DataInputStream in = new DataInputStream(fstream);  

                	  BufferedReader br = new BufferedReader(new InputStreamReader(in)); String strLine;  

                	  for (int j=1;j<=nof;j++)  
                	  {  
                		  //txtOutputPath
                	   FileWriter fstream1 = new FileWriter(txtOutputPath.getText()+"\\"+txtFileName.getText()+"_"+j+".txt");     // Destination File Location  
                	   BufferedWriter out = new BufferedWriter(fstream1);   
                	   if (j==1){
                		   nol=nol+1;
                	   }else{
                		   out.write("Phone No^Message^Send Date^Credit^Send Status^DR Status^create_date^schedule_date^reference_name^sender^user"); 
                    	   out.newLine();  
                	   
                	   }
                	   for (int i=1;i<=nol;i++)  
                	   {  
                	    strLine = br.readLine();   
                	    if (strLine!= null)  
                	    {  
                	     out.write(strLine);   
                	     if(i!=nol)  
                	     {  
                	      out.newLine();  
                	     }  
                	    }  
                	   }  
                	   out.close();  
                	   if (j==1){
                		   nol=nol-1;
                	   }
                	  }  

                	  in.close();  
                	 }catch (Exception e)  
                	 {  
                	  System.err.println("Error: " + e.getMessage());  
                	  
                	  JOptionPane.showMessageDialog(null,
                			  "Error: " + e.getMessage(),
						      "Inane warning",
						      JOptionPane.ERROR_MESSAGE);
					 return;
                	 } 
			}
		});
		btnSplit.setBounds(392, 189, 97, 25);
		panel.add(btnSplit);
		
		JButton btnOutput = new JButton("Choose Path");
		btnOutput.setBackground(Color.ORANGE);
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    JFileChooser chooser = new JFileChooser("C:\\");
			  //  chooser.setCurrentDirectory(new java.io.File("C:"));
			    chooser.setDialogTitle("choosertitle");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			    //  txtOutputPath.setText(chooser.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			      
			      txtOutputPath.setText(chooser.getSelectedFile().toString());
			    } else {
			      System.out.println("No Selection ");
			      txtOutputPath.setText(null);
			    }
				
				
	            
			}
		});
		btnOutput.setBounds(390, 133, 109, 25);
		panel.add(btnOutput);
		
		JButton btnOpenFolder = new JButton("...");
		btnOpenFolder.setForeground(Color.BLUE);
		btnOpenFolder.setBackground(Color.LIGHT_GRAY);
		btnOpenFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(  txtOutputPath.getText().length()<=0){
					 
					 JOptionPane.showMessageDialog(null,
						      "กรุณาเลือกสถานที่เก็บFile",
						      "Inane warning",
						      JOptionPane.WARNING_MESSAGE);
					 return;
				 
				 }
				
				File file = new File (txtOutputPath.getText());
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOpenFolder.setBounds(310, 194, 33, 25);
		panel.add(btnOpenFolder);
	}
}
