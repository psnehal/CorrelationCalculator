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
	
	
	def serviceMethod() {

    }
    
    def listalljobs() {
        println("in service")
        println(TEMP_DIRECTORY)
        def qjobs = Consigparameters.createCriteria()
        def result= qjobs.list {
			eq("status","queued")
		}
        result.each { person ->
					    println "filepath = ${person.filepath}"
					    println "jiindex = ${person.jindex}"
					    println "uuid = ${person.requestId}"					   
					    println "min_con = ${person.minCon}"
					}
        
        def rjobs= Consigparameters.executeQuery("select requestId from Consigparameters where status ='running'")        
        println("below query with queued jobs $result.size() running jobs $rjobs.size")
        def rjobCount = rjobs.size()
        println("1")
        if (rjobCount<2)
        {
          def firstSubJob = result[0]
          println("1")
          println ("firstSubJob  $firstSubJob.requestId")
          def uuid= firstSubJob.uuid
          println("2")
          RConnection connection;
		  connection = new RConnection("localhost", 6311);	
		  println("3")		
		  println("Connected to R")
		  Consigparameters.executeUpdate("update Consigparameters b set b.status=:status " +
                      "where b.requestId=:requestId",
                      [status: 'running', uuid: uuid])
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
             
             
            String inputFile = uuid + "_" + firstSubJob.filename;
            String outputFile = uuid + "_" + firstSubJob.analysis + "_" + OUTPUT_FILE_CSV;
    
    
            println("input file $inputfile")
            println("rowSamples file $firstSubJob.rowsamples")
            println("doScaling file $firstSubJob.doscaling")
            println("exclusionList file $firstSubJob.exclusionlist")
            
            
                    
			connection.assign("inputfile", inputfile);
			connection.assign("outputdirectory", outputdirectory);
			connection.assign("outputfile", outputfile);
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
		    
			String outputString = "";
			outputString= uuid+ OUTPUT_FILE_CSV			
			String outputString2=uuid+ 'coeff_' + OUTPUT_FILE_CSV
			String outputString3=uuid+ 'pval_'+ OUTPUT_FILE_CSV
			String outputString4 =uuid+ 'qval_'+ OUTPUT_FILE_CSV
			
			println("outputString $outputString)
			println("outputString2 $outputString2)
			println("outputString3 $outputString3)
			println("outputString4 $outputString4)
			
			
			File file = new File(TEMP_DIRECTORY + outputString)		
			File file2 = new File(TEMP_DIRECTORY + outputString2)
			File file3 = new File(TEMP_DIRECTORY + outputString3)
			File file4 = new File(TEMP_DIRECTORY + outputString4)
			
			       
           
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
