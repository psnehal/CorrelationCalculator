package testconsig1

import grails.transaction.Transactional
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList
import org.rosuda.REngine.Rserve.*;
import org.rosuda.Rserve.*;

@Transactional
class RetrieveSubmittedJobsService {
	
	RConnection c = new RConnection();
	private static final String OUTPUT_FILE_CSV = "output.csv";
	private static final String OUTPUT_FILE_CDT = "output.cdt";
	private static final String OUTPUT_FILE_ATR = "output.atr";
	private static final String OUTPUT_FILE_GTR = "output.gtr";
	private static final String OUTPUT_FILE_PDF = "output.pdf";
	private static final String NORM_SCRIPT = "norm.r";
	private static final String PEARSON_COEFF_SCRIPT = "pearson_coeff.r";
	private static final String PEARSON_DIST_SCRIPT = "pearson_dist.r";
	private static final String PEARSON_HEATMAP_SCRIPT = "pearson_heatmap.r";
	private static final String PEARSON_CLUSTER_SCRIPT = "pearson_cluster.r";
	private static final String PEARSON_TREECUT_SCRIPT = "pearson_treecut.r";
	private static final String PCOR_BASIC_SCRIPT = "pcor.r";
	private static final String PCOR_LASSO_SCRIPT = "lasso.r";
	private static final String PCOR_BATCH_SCRIPT = "lasso_batch.r";
	private static final String PCOR_COMPARE_SCRIPT = "lipids/lipid_s0_input.R";
	private static final String R_DIRECTORY= "/home/snehal/ConSig/TestGrails/testconsig1/grails-app/services/testconsig1/"
	private static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir") + File.separatorChar;
	private static final String CONSIG_DIRECTORY="/home/snehal/ConSig/PelleScripts/newTestDir/"
	private static final String CONSIG_SCRIPT = "ConSig.R"
	private static final String CONSIG_RESULT = "/usr/share/ConSig/StoreFile"
	
	def serviceMethod() {

    }
    
    def listalljobs() {
        println("in service")
        println(TEMP_DIRECTORY)
        def qjobs = Consigparameters.createCriteria()
        def result= qjobs.list {
			eq("status","queued")
		}        
        def rjobs= Consigparameters.executeQuery("select uuid from Consigparameters where status ='running'")        
        println("below query with queued jobs $result.size() running jobs $rjobs.size")
        def rjobCount = rjobs.size()
        println("1")
        if (rjobCount<2 && result.size != 0)
        {
        
            println(result)
	        def firstSubJob = result[0]	     
	        def status= firstSubJob.status
	        println("Status of current job is "+ status)    
	        println("1")	            	          
	        def filepath= firstSubJob.filepath
		    def jindex= firstSubJob.jindex
		    def mincon= firstSubJob.mincon
		    def maxcon= firstSubJob.maxcon
		    def uuid= firstSubJob.uuid
		    
		    //def conceptlist= firstSubJob.conceptlist
		    def databaselist= firstSubJob.databaselist
		    //def dbflag = firstSubJob.dbflag
		    def geneid=firstSubJob.isgeneid
		    String filOutputFile = CONSIG_RESULT+uuid + "_" + 'filOutputFile';
            String outputFile = CONSIG_RESULT+uuid + "_" + 'consig_output';
            println("CONSIG_RESULT $CONSIG_RESULT")
            def gene2symfile='/home/snehal/ConSig/smallTestDir/entrez2sym'
			def annotation_file='/home/snehal/ConSig/smallTestDir/smallGO2EG.RData'
			def matrix_file='/home/snehal/ConSig/smallTestDir/smallIntMatrix.RData'
			Consigparameters.executeUpdate("update Consigparameters b set b.status=:status " +
                      "where b.uuid=:uuid",
                      [status: 'running', uuid: uuid])
			
							
							if (geneid.equals("geneId"))
							{
							print("its geneid loop")
							
							}
							else
							{
							println("its genesymbol loop")
							def ensym =Entrez2sym.getAll()			
						     def mapidtosym= ensym.collect{ en -> return[enId:en.enId, sym:en.sym]}
								//println(mapidtosym.enId);
								//def item2 = mapidtosym.findAll { p -> p.sym == 'ABG' } 
								//println("*****************************************************"+item2.enId)
								def filepath2 ='/home/snehal/ConSig/StoreFile/'+uuid+'_Sym.txt'
								 File file = new File(filepath2)
									new File(filepath).eachLine 
									{ line ->								  
									   String [] tokens = line.split("\t")
									   println("tokens are")	
									   println(tokens)						
											 def symbol = tokens[2]
											 def item = mapidtosym.findAll { p -> p.sym == symbol }							
											 
											 println("item"+ item+"  "+ symbol)							 
										     item.each {
												       String line2 = "Curate"+"\t"+"AllCancerGene"+"\t"+"${it.enId}\n"
												       file << (line2)
												       println("from the createfile inserterd into the file")
														}
									}
						     }
						   println("2")
				           RConnection connection;
						   connection = new RConnection("localhost", 6311);							  
						   println("Connected to R for uuid $uuid")	
					       connection.assign("geneListFile", filepath);
						   connection.assign("ji.threshold", jindex);
						   connection.assign("size.min", mincon);
						   connection.assign("size.max", maxcon);
						   connection.assign("filter.strings", 'NA');
						   connection.assign("use.databases", databaselist);
						   connection.assign("filtered.file", filOutputFile);
						   connection.assign("output.file", outputFile);
						   connection.assign("entrez2sym.file", gene2symfile);
						   connection.assign("DB.data.file", annotation_file);
						   connection.assign("intMatrix.file", matrix_file);
						   println("3")		
						  //ConSig.R CancerGene_CGC20150525.shuf.1.db smallGO2EG.RData matrix_file entrez2sym 1 5 1500 NA NA filtered.file output
						  try
								{
								   println("above script")
								    REXP r1=  connection.parseAndEval("try("+"source('" + CONSIG_DIRECTORY + CONSIG_SCRIPT + "')"+",silent=TRUE)");
									println("below script")
									if (r1.inherits("try-error")) 
									{
										System.err.println("Error: "+r1.asString());
										status = "Error: "+r1.asString();
										}
									else { 
									     System.out.println("Hello");
										 status = "Done";
										}
									
								}
								catch (RserveException e)
								{
									e.printStackTrace();
									throw new IllegalStateException("Unable to run command  parseAndEval on RServer: " + command);
								}
				             
						    println("status is $status")
						  
						  
						  
						  connection.voidEval("library('gplots')");
						  Consigparameters.executeUpdate("update Consigparameters b set b.status=:status " +
				                      "where b.uuid=:uuid",
				                      [status: 'done', uuid: uuid])
				                      
				                      
						  println("4")		  
						  println("done with the Rserve")
          
			     
          
         }
          
    }
    
    
      def listalljobsCorrelation() {
        println("in service")
         println(TEMP_DIRECTORY)
        def qjobs = Correlation.createCriteria()
        def result= qjobs.list {
			eq("status","queued")
		}
		
		
		
		print("printing..................................")
     //   result.each { person ->
	//				    println "filepath = ${person.analysis}"
		//			    println "doScaling = ${person.doscaling}"
		//			    println "status = ${person.status}"					   
		//			    println "uuid = ${person.requestid}"
		//			}
        
        def rjobs= Correlation.executeQuery("select requestid from Correlation where status ='running'")        
        println("below  listalljobsCorrelation query with queued jobs $result.size running jobs $rjobs.size")
        def rjobCount = rjobs.size
        println("rjobs.size $rjobs.size")
        if (rjobCount<2 && result.size != 0)
        {
          def firstSubJob = result[0]
          println("1 $firstSubJob")
          println ("firstSubJob  $firstSubJob.requestid")
          def uuid= firstSubJob.requestid          
          RConnection connection;
		  connection = new RConnection("localhost", 6311);		  
		  println("Connected to R")
		  //Update status of the job as running
		  Consigparameters.executeUpdate("update Correlation b set b.status=:status " +
                      "where b.requestid=:requestid",
                      [status: 'running', requestid: uuid])
                      
           //Run actual R code for correlation calculator
            
            def inputfile= "/home/snehal/CorrelationAllaProject/aminoacids.csv"
            def outputdirectory="/home/snehal/CorrelationAllaProject/output/"
            def outputfile="output.csv" 
             
             
            String inputFile = TEMP_DIRECTORY+uuid + "_" + firstSubJob.filename;
            String outputFile = uuid + "_" + firstSubJob.analysis + "_" + OUTPUT_FILE_CSV;
    
    
            println("input file $inputFile")
            println(TEMP_DIRECTORY)
            //println("doScaling file $firstSubJob.doscaling")
            //println("exclusionList file $firstSubJob.exclusionlist")
            
            
                    
			connection.assign("inputfile", inputFile);
			connection.assign("outputdirectory", TEMP_DIRECTORY);
			connection.assign("outputfile", outputFile);
			connection.assign("rowSamples", firstSubJob.rowsamples);
			connection.assign("labeledSamples", firstSubJob.labeledsamples);
			connection.assign("doTransform", firstSubJob.dotransform);
			connection.assign("doScaling", firstSubJob.doscaling);
			connection.assign("exclusionList", firstSubJob.exclusionlist);
			connection.assign("pearsonLowerThreshold", 0.2);
			connection.assign("pearsonUpperThreshold", 1);
			//connection.assign("stabSelIters", firstSubJob.getStabSelIters());
			//connection.assign("doBICTune", firstSubJob.getDoBICTune());
			
			
            
             
             String status = "";
				try
				{
					REXP r1=  connection.parseAndEval("try("+"source('" + R_DIRECTORY + PCOR_BASIC_SCRIPT + "')"+",silent=TRUE)");
					if (r1.inherits("try-error")) 
					{
						System.err.println("Error: "+r1.asString());
						status = "Error: "+r1.asString();
						}
					else { 
					     System.out.println("Hello");
						 status = "Done";
						}
					
				}
				catch (RserveException e)
				
				{
					e.printStackTrace();
					throw new IllegalStateException("Unable to run command  parseAndEval on RServer: " + command);
				}
             
		    println("status is $status")	
			       
           
           //Job is done and update status as done..           
			connection.voidEval("library('gplots')");
			Consigparameters.executeUpdate("update Correlation b set b.status=:status " +
	                      "where b.requestid=:requestid",
	                      [status: 'done', requestid: uuid])   
		     println("4")		  
		     println("done with the Rserve")
          
			     
          
         }
          
    }
    
    
    
    
    void checkForScheduledTasks() {
    

    
	}
}
